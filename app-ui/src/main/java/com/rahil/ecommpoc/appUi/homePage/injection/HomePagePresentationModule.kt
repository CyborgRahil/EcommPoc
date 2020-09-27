package com.rahil.ecommpoc.appUi.homePage.injection

import com.rahil.ecommpoc.appUi.homePage.fragment.HomeFragment
import com.rahil.ecommpoc.appUi.injection.scopes.PerFragment
import com.rahil.ecommpoc.domain.interactor.homePage.GetHomePageData
import com.rahil.ecommpoc.presentation.homePage.HomePageContract
import com.rahil.ecommpoc.presentation.homePage.HomePagePresenter
import dagger.Module
import dagger.Provides

/**
 * Module that provides all dependencies from the presentation package/layer.
 */
@Module
class HomePagePresentationModule {

    @Provides
    @PerFragment
    internal fun provideHomePageView(homeFragment: HomeFragment): HomePageContract.HomePageView {
        return homeFragment
    }

    @Provides
    @PerFragment
    internal fun provideHomePagePresenter(mainView: HomePageContract.HomePageView,
                                          getHomePageData: GetHomePageData
    ):
            HomePageContract.HomePagePresenter {
        return HomePagePresenter(mainView, getHomePageData)
    }
}
