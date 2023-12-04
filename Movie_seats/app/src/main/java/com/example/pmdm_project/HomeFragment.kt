package com.example.pmdm_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pmdm_project.adapter.MovieAdapter
import com.example.pmdm_project.databinding.FragmentHomeBinding
import com.example.pmdm_project.model.Movie
import com.example.pmdm_project.retrofit.MovieAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: MovieAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        callAPI()
        initRecyclerView()
        return binding.root
    }

    private fun callAPI() {
        addMovieToList("?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full")
        addMovieToList("?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full")
        addMovieToList("?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full")
    }

    private fun initRecyclerView() {
            adapter = MovieAdapter(movieList)
            binding.recyclerview1.layoutManager = LinearLayoutManager(context)
            binding.recyclerview1.adapter = adapter    }

    //Set retrofit
    private fun getRetrofit() = Retrofit.Builder().baseUrl("https://www.omdbapi.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    //Adds the query to the URL of the retrofit


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //Clicklistener
    //        recycler1.setOnClickListener(View.OnClickListener { view ->
//            onListItemClick.onClick(view, getAdapterPosition()) // passing click to interface
//        })
//        recycler1.adapter = adapter

//        ItemAdapter.setOnClickListener(object :
//            ItemAdapter.OnClickListener {
//            override fun onClick(position: Int, model: Employee) {
//                val intent = Intent(this@MainActivity, EmployeeDetails::class.java)
//                // Passing the data to the
//                // EmployeeDetails Activity
//                intent.putExtra(NEXT_SCREEN, model)
//                startActivity(intent)
//            }
//        })
}

