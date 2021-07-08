package com.jramirez.instamovies.domain.usecase

import com.jramirez.instamovies.data.model.Movie
import com.jramirez.instamovies.domain.model.MovieGenre

interface GetMoviesUseCase {

    suspend fun execute(): Map<MovieGenre, List<Movie>>
}