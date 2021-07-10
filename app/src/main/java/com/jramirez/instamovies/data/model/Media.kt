package com.jramirez.instamovies.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Media(
    val id: Int,
    @SerializedName("original_title") val originalTitle: String?,
    @SerializedName("original_name") val originalName: String?,
    val overview: String,
    @SerializedName("release_date") val releaseDate: String?,
    @SerializedName("first_air_date") val firstAirDate: String?,
    @SerializedName("poster_path") var posterPath: String,
    @SerializedName("vote_average") val voteAverage: Float
) : Parcelable
