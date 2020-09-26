package com.rahil.ecommpoc.domain.repository

import com.rahil.ecommpoc.domain.model.homepage.HomePageModel
import io.reactivex.Single

interface AppRepository {
    fun getHomePageData(): Single<HomePageModel>
}