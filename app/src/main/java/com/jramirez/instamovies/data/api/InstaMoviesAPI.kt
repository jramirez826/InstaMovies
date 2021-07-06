package com.jramirez.instamovies.data.api

import com.jramirez.instamovies.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface InstaMoviesAPI {

    @GET("discover/movie")
    suspend fun getMoviesByCategory(@Query("api_key") apiKey: String = BuildConfig.API_KEY,
                                    @Query("with_genres") genre: String)

    @GET("discover/tv")
    suspend fun getTvSeriesByCategory(@Query("api_key") apiKey: String = BuildConfig.API_KEY,
                                      @Query("with_genres") genre: String)

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(@Query("movie_id") id: String,
                               @Path("api_key") apiKey: String = BuildConfig.API_KEY)

    @GET("/tv/{tv_id}")
    suspend fun getTvSeriesDetail(@Query("tv_id") id: String,
                               @Path("api_key") apiKey: String = BuildConfig.API_KEY)
}