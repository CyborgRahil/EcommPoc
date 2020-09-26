package com.rahil.ecommpoc.domain.repository

import com.rahil.ecommpoc.domain.model.homepage.HomePageModel
import io.reactivex.Flowable

interface AppRepository {
    fun getHomePageData(): Flowable<HomePageModel>
}