package com.example.pmdm_project.model

data class Movie(
    val title: String?,
    val runtime: String?,
    val genres: LinkedHashSet<Genre>?,
    val director: String?,
    val actors: String?,
    val plot: String?,
    val poster: String?,
    val ratings: ArrayList<Rating>?
)