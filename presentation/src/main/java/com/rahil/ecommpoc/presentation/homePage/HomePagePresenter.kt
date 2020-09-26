package com.rahil.ecommpoc.presentation.homePage

import com.rahil.ecommpoc.domain.interactor.homePage.GetHomePageData
import com.rahil.ecommpoc.domain.model.homepage.HomePageModel
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class HomePagePresenter @Inject constructor(private val homePageView: HomePageContract.HomePageView,
                                            private val getHomePageDataUseCase: GetHomePageData):
    HomePageContract.HomePagePresenter {

    init {
        homePageView.setPresenter(this)
    }

    override fun start() {
        homePageView.showProgress()
        retrieveHomePageData()
    }

    override fun stop() {
        getHomePageDataUseCase.dispose()
    }

    override fun retrieveHomePageData() {
        getHomePageDataUseCase.execute(HomePageDataSubscriber())
    }

    fun handleGetHomePageDataSuccess(homePageModel: HomePageModel) {
        homePageView.hideProgress()
        homePageView.hideErrorState()
        homePageView.hideEmptyState()
        homePageView.showHomeData(homePageModel)
    }

    inner class HomePageDataSubscriber : DisposableSingleObserver<HomePageModel>() {

        override fun onError(exception: Throwable) {
            homePageView.hideProgress()
            homePageView.hideEmptyState()
            homePageView.showErrorState()
        }

        override fun onSuccess(homePageModel: HomePageModel) {
            handleGetHomePageDataSuccess(homePageModel)
        }

    }
}
