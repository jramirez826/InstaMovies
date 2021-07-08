package com.jramirez.instamovies.data.repository

import com.jramirez.instamovies.data.model.Movie

interface MoviesRepository {

    suspend fun getMovies(genreId: Int) : List<Movie>
}