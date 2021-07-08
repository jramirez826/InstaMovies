package com.jramirez.instamovies.data.repository

import com.jramirez.instamovies.data.api.InstaMoviesAPI
import com.jramirez.instamovies.data.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(override val apiClient: InstaMoviesAPI) :
    BaseRepository(), MoviesRepository {

    override suspend fun getMovies(genreId: Int): List<Movie> {
        return withContext(Dispatchers.IO) {
            val response = apiClient.getMoviesByGenre(genre = genreId)
            if (response.isSuccessful) {
                response.body()?.results ?: emptyList()
            } else {
                emptyList()
            }
        }
    }
}