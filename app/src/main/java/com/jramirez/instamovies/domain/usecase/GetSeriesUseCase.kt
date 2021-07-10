package com.jramirez.instamovies.domain.usecase

interface GetSeriesUseCase {
    suspend fun execute(): List<Any>
}