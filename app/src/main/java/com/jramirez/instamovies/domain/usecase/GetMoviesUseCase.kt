package com.jramirez.instamovies.domain.usecase

interface GetMoviesUseCase {

    suspend fun execute(): List<Any>
}