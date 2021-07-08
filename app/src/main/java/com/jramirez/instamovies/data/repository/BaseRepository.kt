package com.jramirez.instamovies.data.repository

import com.jramirez.instamovies.data.api.InstaMoviesAPI

abstract class BaseRepository {

    abstract val apiClient: InstaMoviesAPI
}