package com.example.pmdm_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pmdm_project.adapter.ItemAdapter
import com.example.pmdm_project.databinding.FragmentHomeBinding
import com.example.pmdm_project.model.Movie

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val movieList: List<String> = MovieList().loadMoviesHot()
        val adapter: ItemAdapter = ItemAdapter(movieList)
        val recycler1 = binding.recyclerview1
//        recycler1.setOnClickListener(View.OnClickListener { view ->
//            onListItemClick.onClick(view, getAdapterPosition()) // passing click to interface
//        })
        recycler1.adapter = adapter

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

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
