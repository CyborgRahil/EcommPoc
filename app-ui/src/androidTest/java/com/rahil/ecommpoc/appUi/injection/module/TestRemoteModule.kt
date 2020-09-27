package com.rahil.ecommpoc.appUi.injection.module

import com.nhaarman.mockito_kotlin.mock
import com.rahil.ecommpoc.data.repository.AppRemote
import com.rahil.ecommpoc.remote.service.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object TestRemoteModule {

    @Provides
    @JvmStatic
    @Singleton
    fun provideAppRemote(): AppRemote {
        return mock()
    }

    @Provides
    @JvmStatic
    @Singleton
    fun provideApiService(): ApiService {
        return mock()
    }
}