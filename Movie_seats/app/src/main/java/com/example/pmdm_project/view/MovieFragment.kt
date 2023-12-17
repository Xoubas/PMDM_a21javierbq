package com.example.pmdm_project.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.OvershootInterpolator
import androidx.navigation.fragment.navArgs
import com.example.pmdm_project.R
import com.example.pmdm_project.databinding.FragmentMovieBinding
import com.example.pmdm_project.model.Movie

class MovieFragment : Fragment() {
    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<MovieFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        val expandablePlot = binding.plotShow
        val expandButton = binding.expandPlotButton
        binding.titleShow.text=args.movie.title

        // setting animation

        expandablePlot.setAnimationDuration(750L)

        // setting the interpolator

        expandablePlot.setInterpolator(OvershootInterpolator())

        // checking the status of the expandable txt and setting the new status
        // setting the text on the expandButton

        expandButton.setOnClickListener {
            if (expandablePlot.isExpanded) {
                expandablePlot.collapse()
                expandButton.setText(R.string.expand_button)
            } else {
                expandablePlot.expand()
                expandButton.setText(R.string.collapse_button)
            }
        }
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    private fun setUpMovieInformation() {

    }
}