package com.example.pmdm_project.view

import com.example.pmdm_project.model.Movie
import com.example.pmdm_project.model.MovieDAO
import java.net.URL

class MovieList {
    fun loadMoviesHot(): List<String> {
        return listOf<String>(
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=Blade+runner+2049&plot=full",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=inception&plot=full",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=the+nice+guys&plot=full",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full"
        )
    }

    fun loadMoviesNR(): List<String> {
        return listOf<String>(
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full"
        )
    }

    fun loadMoviesOld(): List<String> {
        return listOf<String>(
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full"
        )
    }
}