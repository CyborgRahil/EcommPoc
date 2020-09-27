package com.rahil.ecommpoc.appUi.injection

import android.app.Application
import com.rahil.ecommpoc.appUi.injection.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import com.rahil.ecommpoc.appUi.EcommApplication
import com.rahil.ecommpoc.appUi.injection.scopes.PerApplication
import com.rahil.ecommpoc.appUi.injection.module.DomainModule

@PerApplication
@Component(modules = arrayOf(
        ApplicationModule::class,
        AndroidSupportInjectionModule::class,
        DataModule::class,
        PresentationModule::class,
        DomainModule::class,
        RemoteModule::class,
        UiModule::class)
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: EcommApplication)
}
