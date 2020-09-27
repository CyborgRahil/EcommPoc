package com.rahil.ecommpoc.appUi.injection.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import com.rahil.ecommpoc.appUi.injection.module.TestDataModule
import com.rahil.ecommpoc.appUi.injection.module.TestRemoteModule
import com.rahil.ecommpoc.appUi.injection.ApplicationComponent
import com.rahil.ecommpoc.appUi.injection.module.PresentationModule
import com.rahil.ecommpoc.appUi.injection.module.UiModule
import com.rahil.ecommpoc.domain.executor.PostExecutionThread
import com.rahil.ecommpoc.domain.executor.ThreadExecutor
import com.rahil.ecommpoc.domain.repository.AppRepository
import com.rahil.ecommpoc.appUi.test.TestApplication
import com.rahil.ecommpoc.appUi.injection.module.TestApplicationModule
import com.rahil.ecommpoc.appUi.injection.scopes.PerApplication
import javax.inject.Singleton

@Component(modules = arrayOf(
        TestApplicationModule::class,
        AndroidSupportInjectionModule::class,
        TestRemoteModule::class,
        TestDataModule::class,
        PresentationModule::class))
interface TestApplicationComponent : ApplicationComponent {

    fun inject(application: TestApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): TestApplicationComponent
    }

}