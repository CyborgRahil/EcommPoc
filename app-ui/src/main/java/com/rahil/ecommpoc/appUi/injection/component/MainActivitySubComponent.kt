package com.rahil.ecommpoc.appUi.injection.component

import com.rahil.ecommpoc.appUi.homePage.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface MainActivitySubComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()

}