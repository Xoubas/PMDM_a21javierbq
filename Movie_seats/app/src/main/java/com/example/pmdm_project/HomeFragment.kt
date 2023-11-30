package com.example.pmdm_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pmdm_project.adapter.ItemAdapter
import com.example.pmdm_project.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val movieList: List<String> = PopularMovies().loadMoviesHot()
        val adapter: ItemAdapter = ItemAdapter(movieList)
        val recycler1 = binding.recyclerview1
//        recycler1.setOnClickListener(View.OnClickListener { view ->
//            onListItemClick.onClick(view, getAdapterPosition()) // passing click to interface
//        })
        recycler1.adapter = adapter
        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        setupAlphabetRecyclerView()
//    }

//    private fun setupAlphabetRecyclerView() {
//        val mlayoutmanager = LinearLayoutManager(activity)
//        mlayoutmanager.orientation = LinearLayoutManager.HORIZONTAL
//        val movieList = PopularMovies().loadMoviesHot()

//        binding.recyclercities.layoutManager = LinearLayoutManager(requireContext())
    //val adapter = CityAdapter(CityProvider.cities)
//        binding.recyclercities.adapter = adapter

    //        binding.rvWords.apply {
//            wordAdapter = WordAdapter(wordList)
//            adapter = wordAdapter
//            layoutManager = mlayoutmanager
//        }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
