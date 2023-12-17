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
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=fight+club",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=all+quiet+on+the+western+front",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=prometheus",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=no+country+for+old+men"
        )
    }

    fun loadMoviesNR(): List<String> {
        return listOf<String>(
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=chinatown&plot=full",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=american+history+x",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=spirited+away",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=Lord+of+the+rings%3A+the+two+towers",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=Monster+House",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=iron+man",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=top+gun&plot=full",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=the+bridges+of+madison&plot=full"
        )
    }

    fun loadMoviesOld(): List<String> {
        return listOf<String>(
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=rocky",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=pulp+fiction",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=E.T.",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=star+wars%3A+Episode+VI",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=jaws",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=goodfellas",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=The+shining",
            "https://www.omdbapi.com/?apikey=8a6a73eb&t=back+to+the+future"
        )
    }
//    fun loadMoviesHot(): List<String> {
//        return listOf<String>(
//            "https://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full",
//            "https://www.omdbapi.com/?apikey=8a6a73eb&t=Blade+runner+2049&plot=full",
//            "https://www.omdbapi.com/?apikey=8a6a73eb&t=inception&plot=full",
//            "https://www.omdbapi.com/?apikey=8a6a73eb&t=the+nice+guys&plot=full",
//            "https://www.omdbapi.com/?apikey=8a6a73eb&t=fight+club",
//            "https://www.omdbapi.com/?apikey=8a6a73eb&t=all+quiet+on+the+western+front",
//            "https://www.omdbapi.com/?apikey=8a6a73eb&t=prometheus",
//            "https://www.omdbapi.com/?apikey=8a6a73eb&t=no+country+for+old+men"
//        )
//    }
//
//    fun loadMoviesNR(): List<String> {
//        return listOf<String>(
//            "https://www.omdbapi.com/?apikey=8a6a73eb&t=star+wars%3A+Episode+III",
//            "https://www.omdbapi.com/?apikey=8a6a73eb&t=Lord+of+the+rings%3A+the+two+towers",
//            "https://www.omdbapi.com/?apikey=8a6a73eb&t=spirited+away",
//            "https://www.omdbapi.com/?apikey=8a6a73eb&t=american+history+x",
//            "https://www.omdbapi.com/?apikey=8a6a73eb&t=Monster+House",
//            "https://www.omdbapi.com/?apikey=8a6a73eb&t=cell+211&plot=full",
//            "https://www.omdbapi.com/?apikey=8a6a73eb&t=iron+man",
//            "https://www.omdbapi.com/?apikey=8a6a73eb&t=top+gun&plot=full"
//        )
//    }
//
//    fun loadMoviesOld(): List<String> {
//        return listOf<String>(
//            "https://www.omdbapi.com/?apikey=8a6a73eb&t=rocky",
//            "https://www.omdbapi.com/?apikey=8a6a73eb&t=pulp+fiction",
//            "https://www.omdbapi.com/?apikey=8a6a73eb&t=E.T.",
//            "https://www.omdbapi.com/?apikey=8a6a73eb&t=star+wars%3A+Episode+VI",
//            "https://www.omdbapi.com/?apikey=8a6a73eb&t=jaws",
//            "https://www.omdbapi.com/?apikey=8a6a73eb&t=goodfellas",
//            "https://www.omdbapi.com/?apikey=8a6a73eb&t=The+shining",
//            "https://www.omdbapi.com/?apikey=8a6a73eb&t=back+to+the+future"
//        )
//    }
}