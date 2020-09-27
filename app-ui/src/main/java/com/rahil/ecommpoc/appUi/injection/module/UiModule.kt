package com.rahil.ecommpoc.appUi.injection.module

import com.rahil.ecommpoc.appUi.UiThread
import com.rahil.ecommpoc.appUi.homePage.MainActivity
import com.rahil.ecommpoc.appUi.homePage.injection.HomePageModule
import com.rahil.ecommpoc.domain.executor.PostExecutionThread
import com.rahil.ecommpoc.appUi.injection.scopes.PerActivity
import com.rahil.ecommpoc.appUi.injection.scopes.PerApplication
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Module that provides all dependencies from the mobile-ui package/layer and injects all activities.
 */
@Module
abstract class UiModule {

    @Binds
    @PerApplication
    abstract fun bindPostExecutionThread(uiThread: UiThread): PostExecutionThread

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(HomePageModule::class))
    abstract fun bindMainActivity(): MainActivity
}