package com.rahil.ecommpoc.presentation.homePage

import com.rahil.ecommpoc.domain.model.homepage.HomePageModel
import com.rahil.ecommpoc.presentation.BasePresenter
import com.rahil.ecommpoc.presentation.BaseView

interface HomePageContract {
    interface HomePageView : BaseView<HomePagePresenter> {

        fun showProgress()

        fun hideProgress()

        fun showHomeData(homePageData: HomePageModel)

        fun showErrorState()

        fun hideErrorState()

        fun showEmptyState()

        fun hideEmptyState()
    }

    interface HomePagePresenter : BasePresenter {
        fun retrieveHomePageData()
    }
}