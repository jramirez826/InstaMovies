package com.jramirez.instamovies.domain.usecase

import com.jramirez.instamovies.data.repository.MoviesRepository
import com.jramirez.instamovies.domain.model.MovieGenre
import javax.inject.Inject

class GetMoviesUseCaseImpl @Inject constructor(private val moviesRepository: MoviesRepository) :
    GetMoviesUseCase {

    override suspend fun execute(): List<Any> {
        val result: MutableList<Any> = mutableListOf()
        enumValues<MovieGenre>().forEach {
            result.add(it)
            val movies = moviesRepository.getMedia(it.id())
            result.addAll(movies)
        }
        return result
    }
}