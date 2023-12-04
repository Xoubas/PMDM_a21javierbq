package com.example.pmdm_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.*
import com.android.volley.toolbox.*
import com.android.volley.Response
import com.example.pmdm_project.adapter.MovieAdapter
import com.example.pmdm_project.databinding.FragmentHomeBinding
import com.example.pmdm_project.model.Movie
import org.json.JSONObject

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: MovieAdapter
    private var movieList = mutableListOf<Movie>()
    private lateinit var requestQueue: RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        requestQueue = Volley.newRequestQueue(requireContext())
        parseJson()
        initRecyclerView()
        return binding.root
    }

    private fun parseJson() {
        val url: String =
            "http://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full"
        val request = JsonObjectRequest(Request.Method.GET, url, null,
            { response: JSONObject ->
                try {
                    //Añadir aqui el objeto
                        val creatorName = hit.getString("user")
                        val imageUrl = hit.getString("webformatURL")
                        val likeCount = hit.getInt("likes")

                        mExampleList.add(ExampleItem(imageUrl, creatorName, likeCount))

                    mExampleAdapter = ExampleAdapter(this@MainActivity, mExampleList)
                    mRecyclerView.adapter = mExampleAdapter

                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            { error: VolleyError ->
                error.printStackTrace()
            }
        )

    }

    private fun initRecyclerView() {
        adapter = MovieAdapter(movieList, requireContext())
        binding.recyclerview1.layoutManager = LinearLayoutManager(context)
        binding.recyclerview1.adapter = adapter
    }

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
