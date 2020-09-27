package com.rahil.ecommpoc.appUi.injection.module

import com.rahil.ecommpoc.data.AppDataRepository
import com.rahil.ecommpoc.data.executor.JobExecutor
import com.rahil.ecommpoc.domain.executor.ThreadExecutor
import com.rahil.ecommpoc.domain.repository.AppRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun bindNewsRepository(appDataRepository: AppDataRepository): AppRepository

    @Binds
    abstract fun bindThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor
}