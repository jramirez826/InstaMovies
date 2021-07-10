package com.jramirez.instamovies.di

import com.jramirez.instamovies.data.repository.MoviesRepository
import com.jramirez.instamovies.data.repository.MoviesRepositoryImpl
import com.jramirez.instamovies.data.repository.SeriesRepository
import com.jramirez.instamovies.data.repository.SeriesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindMoviesRepository(impl: MoviesRepositoryImpl): MoviesRepository

    @Binds
    abstract fun bindSeriesRepository(impl: SeriesRepositoryImpl): SeriesRepository
}