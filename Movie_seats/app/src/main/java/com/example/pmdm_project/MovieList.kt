//package com.example.pmdm_project
//
//import com.example.pmdm_project.model.Movie
//import com.example.pmdm_project.model.MovieDAO
//import java.net.URL
//
//class MovieList {
//    fun loadMoviesHot(): List<String> {
//        return listOf<String>("fsafds","dfsdfd","dsfdbnjjn","dsfdbnjjn","dsfdbnjjn","dsfdbnjjn","dsfdbnjjn")
//    }
//    fun loadMoviesNR(): List<Movie> {
//        return listOf<Movie>(
//            MovieDAO().getMovie(URL("http://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full")),
//            MovieDAO().getMovie(URL("http://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full")),
//            MovieDAO().getMovie(URL("http://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full")),
//            MovieDAO().getMovie(URL("http://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full")),
//            MovieDAO().getMovie(URL("http://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full")),
//            MovieDAO().getMovie(URL("http://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full")),
//            MovieDAO().getMovie(URL("http://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full"))
//        )
//    }
//    fun loadMoviesOld(): List<Movie> {
//        return listOf<Movie>(
//            MovieDAO().getMovie(URL("http://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full")),
//            MovieDAO().getMovie(URL("http://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full")),
//            MovieDAO().getMovie(URL("http://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full")),
//            MovieDAO().getMovie(URL("http://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full")),
//            MovieDAO().getMovie(URL("http://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full")),
//            MovieDAO().getMovie(URL("http://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full")),
//            MovieDAO().getMovie(URL("http://www.omdbapi.com/?apikey=8a6a73eb&t=Howl%27s+moving+castle&plot=full"))
//        )
//    }
//}