package com.jramirez.instamovies.domain.usecase

import com.jramirez.instamovies.data.model.Movie
import com.jramirez.instamovies.data.repository.MoviesRepository
import com.jramirez.instamovies.domain.model.MovieGenre
import javax.inject.Inject

class GetMoviesUseCaseImpl @Inject constructor(val moviesRepository: MoviesRepository) :
    GetMoviesUseCase {

    override suspend fun execute(): Map<MovieGenre, List<Movie>> {
        val result = mutableMapOf<MovieGenre, List<Movie>>()
        enumValues<MovieGenre>().forEach {
            val movies = moviesRepository.getMovies(it.id)
            result[it] = movies
        }
        return result
    }
}