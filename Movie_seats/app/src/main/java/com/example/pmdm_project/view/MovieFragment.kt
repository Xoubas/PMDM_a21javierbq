package com.example.pmdm_project.view

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.OvershootInterpolator
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.example.pmdm_project.R
import com.example.pmdm_project.databinding.FragmentMovieBinding
import com.example.pmdm_project.model.Movie
import com.squareup.picasso.Picasso

class MovieFragment : Fragment() {
    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<MovieFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        val expandablePlot = binding.plotContent
        val expandButton = binding.expandPlotButton
        val movie: Movie = args.movie
        setUpMovieInformation(movie)

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
        return binding.root
    }

    private fun setUpMovieInformation(movie: Movie) {
        Glide.with(this)
            .load(movie.poster)
            .into(object : CustomTarget<Drawable>() {
                override fun onLoadCleared(placeholder: Drawable?) {
                    // Do nothing
                }

                override fun onResourceReady(
                    resource: Drawable,
                    transition: com.bumptech.glide.request.transition.Transition<in Drawable>?
                ) {
                    // Set the loaded image as the background of the fragment
                    binding.root.background = resource
                }
            })
        Picasso.get().load(movie.poster).into(binding.moviePosterContent)
        binding.titleContent.text = movie.title
        binding.durationContent.text = movie.runtime
        //Genres
        val genres: LinkedHashSet<String>? = args.movie.genres
        val genresString: String = genres?.joinToString(", ") ?: ""
        binding.categoriesContent.text = genresString
        binding.directorContent.text = movie.director
        binding.actorsContent.text = movie.actors
        binding.metascoreContent.text = movie.meta.toString()
        binding.plotContent.text=movie.plot
    }
}