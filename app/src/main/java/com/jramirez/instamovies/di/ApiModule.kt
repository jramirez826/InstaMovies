package com.jramirez.instamovies.di

import com.google.gson.GsonBuilder
import com.jramirez.instamovies.BuildConfig
import com.jramirez.instamovies.data.api.InstaMoviesAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ApiModule {

    @Singleton
    @Provides
    fun provideApiClient(): InstaMoviesAPI =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create(GsonBuilder().setLenient().create())
            )
            .build()
            .create(InstaMoviesAPI::class.java)
}