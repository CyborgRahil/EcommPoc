package com.rahil.ecommpoc.data.source

import com.rahil.ecommpoc.data.repository.AppDataSource
import javax.inject.Inject

open class AppDataSourceFactory @Inject constructor(
    private val projectsRemoteDataSource: AppRemoteDataSource
) {
    open fun getDataSource(): AppDataSource {
        // We can write a code here to take a decision where we are getting data from cache or remote
        // In current implementation we are not caching anything, So return remoteDataSource from here
        return retrieveRemoteDataStore()
    }

    /**
     * Return an instance of the Remote Data Store
     */
    open fun retrieveRemoteDataStore(): AppDataSource {
        return projectsRemoteDataSource
    }
}
