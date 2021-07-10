package com.jramirez.instamovies.data.api

import com.jramirez.instamovies.BuildConfig
import com.jramirez.instamovies.data.model.GetMediaResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface InstaMoviesAPI {

    @GET("discover/movie")
    suspend fun getMoviesByGenre(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("with_genres") genre: Int
    ): Response<GetMediaResponse>

    @GET("discover/tv")
    suspend fun getTvSeriesByCategory(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("with_genres") genre: Int
    ): Response<GetMediaResponse>
}