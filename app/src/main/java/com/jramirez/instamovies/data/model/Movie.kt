package com.jramirez.instamovies.data.model

import com.google.gson.annotations.SerializedName

data class Movie(
    val id: Int,
    @SerializedName("original_title") val originalTitle: String,
    val overview: String,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("poster_path") var posterPath: String,
    @SerializedName("vote_average") val voteAverage: Float
)
