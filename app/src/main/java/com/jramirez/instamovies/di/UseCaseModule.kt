package com.jramirez.instamovies.di

import com.jramirez.instamovies.domain.usecase.GetMoviesUseCase
import com.jramirez.instamovies.domain.usecase.GetMoviesUseCaseImpl
import com.jramirez.instamovies.domain.usecase.GetSeriesUseCase
import com.jramirez.instamovies.domain.usecase.GetSeriesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class UseCaseModule {

    @Binds
    abstract fun bindGetMoviesUseCase(impl: GetMoviesUseCaseImpl): GetMoviesUseCase

    @Binds
    abstract fun bindGetSeriesUseCase(impl: GetSeriesUseCaseImpl): GetSeriesUseCase
}