package com.jramirez.instamovies.domain.usecase

import com.jramirez.instamovies.data.repository.SeriesRepository
import com.jramirez.instamovies.domain.model.SeriesGenre
import javax.inject.Inject

class GetSeriesUseCaseImpl @Inject constructor(private val seriesRepository: SeriesRepository) :
    GetSeriesUseCase {

    override suspend fun execute(): List<Any> {
        val result: MutableList<Any> = mutableListOf()
        enumValues<SeriesGenre>().forEach {
            result.add(it)
            val movies = seriesRepository.getMedia(it.id())
            result.addAll(movies)
        }
        return result
    }
}