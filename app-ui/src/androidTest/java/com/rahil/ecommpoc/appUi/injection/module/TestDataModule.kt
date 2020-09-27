package com.rahil.ecommpoc.appUi.injection.module

import com.nhaarman.mockito_kotlin.mock
import com.rahil.ecommpoc.data.executor.JobExecutor
import com.rahil.ecommpoc.domain.executor.ThreadExecutor
import com.rahil.ecommpoc.domain.repository.AppRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class TestDataModule {

    @Module
    companion object {

        @Provides
        @JvmStatic
        @Singleton
        fun provideAppRepository(): AppRepository {
            return mock()
        }

        @Provides
        @JvmStatic
        @Singleton
        fun bindThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
            return mock()
        }
    }
}
