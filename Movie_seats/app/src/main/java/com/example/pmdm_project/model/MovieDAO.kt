package com.example.pmdm_project.model
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.BufferedReader
import java.io.FileReader
import java.io.InputStreamReader
import java.net.URL

class MovieDAO {
    fun getMovie(json: String): Movie {
        val gson: Gson = GsonBuilder().setPrettyPrinting()
            .serializeNulls().registerTypeAdapter(Movie::class.java, MovieTypeAdapter()).create()

        return gson.fromJson(json, Movie::class.java)
    }
}