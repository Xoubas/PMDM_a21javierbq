package com.example.pmdm_project.retrofit

import com.example.pmdm_project.model.Movie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface MovieAPI {
    @GET
    suspend fun getMovie(@Url url: String): Response<Movie>
}
