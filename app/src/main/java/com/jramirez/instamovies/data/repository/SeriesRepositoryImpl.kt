package com.jramirez.instamovies.data.repository

import com.jramirez.instamovies.BuildConfig
import com.jramirez.instamovies.data.api.InstaMoviesAPI
import com.jramirez.instamovies.data.model.Media
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SeriesRepositoryImpl @Inject constructor(override val apiClient: InstaMoviesAPI) :
    BaseRepository(), SeriesRepository {

    override suspend fun getMedia(genreId: Int): List<Media> {
        return withContext(Dispatchers.IO) {
            val response = apiClient.getTvSeriesByCategory(genre = genreId)
            if (response.isSuccessful) {
                response.body()?.results?.forEach {
                    it.posterPath = BuildConfig.IMAGES_URL + it.posterPath
                }
                response.body()?.results ?: emptyList()
            } else {
                emptyList()
            }
        }
    }
}