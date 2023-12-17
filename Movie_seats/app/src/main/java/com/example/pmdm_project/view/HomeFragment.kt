package com.example.pmdm_project.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.*
import com.android.volley.toolbox.*
import com.example.pmdm_project.R
import com.example.pmdm_project.adapter.MovieAdapter
import com.example.pmdm_project.databinding.FragmentHomeBinding
import com.example.pmdm_project.model.Movie
import com.example.pmdm_project.model.MovieClickListener
import com.example.pmdm_project.model.MovieDAO
import kotlinx.coroutines.*


class HomeFragment : Fragment(), MovieClickListener {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: MovieAdapter
    private val addressesLists: MovieList = MovieList()
    private var movieList = mutableListOf<Movie>()

    private
    val parser: MovieDAO = MovieDAO()
    private lateinit var requestQueue: RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        requestQueue = Volley.newRequestQueue(requireContext())

        parseJson(addressesLists.loadMoviesHot(), binding.recyclerviewHotMovies)
//        parseJson(addressesLists.loadMoviesNR(), binding.recyclerviewNotReleased)
//        parseJson(addressesLists.loadMoviesOld(), binding.recyclerviewClassics)

        return binding.root
    }

    // Functions
    private fun parseJson(urls: List<String>, recyclerView: RecyclerView) {
        CoroutineScope(Dispatchers.IO).launch {
            val deferredMovies = urls.map { url ->
                async {
                    val deferredMovie = CompletableDeferred<Movie?>()

                    val jsonObjectRequest = JsonObjectRequest(
                        Request.Method.GET, url, null,
                        { response ->
                            val movie: Movie = parser.getMovie(response.toString())
                            deferredMovie.complete(movie)
                        },
                        {
                            Toast.makeText(requireContext(), "Fail to get data", Toast.LENGTH_LONG)
                                .show()
                            deferredMovie.complete(null)
                        }
                    )

                    requestQueue.add(jsonObjectRequest)

                    deferredMovie.await()
                }
            }

            val movies = deferredMovies.awaitAll()

            withContext(Dispatchers.Main) {
                when (recyclerView) {
                    binding.recyclerviewHotMovies -> {
                        val hotMovies = movies.filterNotNull()
                        binding.recyclerviewHotMovies.adapter =
                            MovieAdapter(hotMovies, requireContext(), this@HomeFragment)
                    }

                    binding.recyclerviewNotReleased -> {
                        val notReleasedMovies = movies.filterNotNull()
                        binding.recyclerviewNotReleased.adapter =
                            MovieAdapter(notReleasedMovies, requireContext(), this@HomeFragment)
                    }

                    binding.recyclerviewClassics -> {
                        val classicsMovies = movies.filterNotNull()
                        binding.recyclerviewClassics.adapter =
                            MovieAdapter(classicsMovies, requireContext(), this@HomeFragment)
                    }
                }
            }
        }
    }

    override fun movieClick(movie: Movie) {
        Toast.makeText(requireContext(), "Clicked on ${movie.title}", Toast.LENGTH_SHORT).show()
        val view = binding.root
        val action= HomeFragmentDirections.actionHomeFragmentToMovieFragment(movie)
        view.findNavController().navigate(R.id.action_homeFragment_to_movieFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
