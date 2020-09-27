package com.rahil.ecommpoc.appUi.injection.module

import androidx.multidex.BuildConfig
import com.rahil.ecommpoc.data.repository.AppRemote
import com.rahil.ecommpoc.remote.AppRemoteImpl
import com.rahil.ecommpoc.remote.service.ApiService
import com.rahil.ecommpoc.remote.service.ApiServiceFactory
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 * Module that provides all dependencies from the repository package/layer.
 */
@Module
abstract class RemoteModule {

    /**
     * This companion object annotated as a module is necessary in order to provide dependencies
     * statically in case the wrapping module is an abstract class (to use binding)
     */
    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideApiService(): ApiService {
            return ApiServiceFactory.makeApiService(BuildConfig.DEBUG)
        }
    }

    @Binds
    abstract fun bindAppRemote(appRemoteImpl: AppRemoteImpl): AppRemote
}