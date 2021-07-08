package com.jramirez.instamovies.data.api

import com.jramirez.instamovies.BuildConfig
import com.jramirez.instamovies.data.model.GetMoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface InstaMoviesAPI {

    @GET("discover/movie")
    suspend fun getMoviesByGenre(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("with_genres") genre: Int
    ): Response<GetMoviesResponse>

    @GET("discover/tv")
    suspend fun getTvSeriesByCategory(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("with_genres") genre: String
    )

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Query("movie_id") id: String,
        @Path("api_key") apiKey: String = BuildConfig.API_KEY
    )

    @GET("/tv/{tv_id}")
    suspend fun getTvSeriesDetail(
        @Query("tv_id") id: String,
        @Path("api_key") apiKey: String = BuildConfig.API_KEY
    )
}