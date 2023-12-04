package com.example.pmdm_project.retrofit

import android.widget.Toast
import com.example.pmdm_project.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Retro {
    private var movieList = mutableListOf<Movie>()

    private fun addMovieToList(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(MovieAPI::class.java).getMovie(query)
            val movie = call.body()
            activity?.runOnUiThread {
                if (call.isSuccessful) {
                    movieList.add(movie!!)
                } else {
                    Toast.makeText(activity, call.isSuccessful.toString(), Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}