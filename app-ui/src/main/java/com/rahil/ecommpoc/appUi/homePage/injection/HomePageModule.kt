package com.rahil.ecommpoc.appUi.homePage.injection

import com.rahil.ecommpoc.appUi.homePage.fragment.EmptyFragment
import com.rahil.ecommpoc.appUi.homePage.fragment.HomeFragment
import com.rahil.ecommpoc.appUi.injection.scopes.PerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomePageModule {

    @PerFragment
    @ContributesAndroidInjector(modules = [(HomePagePresentationModule::class)])
    abstract fun bindHomeFragment(): HomeFragment

    @PerFragment
    @ContributesAndroidInjector
    abstract fun bindEmptyFragment(): EmptyFragment
}