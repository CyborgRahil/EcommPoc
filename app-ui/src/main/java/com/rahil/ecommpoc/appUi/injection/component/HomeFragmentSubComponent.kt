package com.rahil.ecommpoc.appUi.injection.component

import com.rahil.ecommpoc.appUi.homePage.fragment.HomeFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface HomeFragmentSubComponent : AndroidInjector<HomeFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<HomeFragment>()

}