package com.rahil.ecommpoc.data.repository

import com.rahil.ecommpoc.data.model.HomePageEntity
import com.rahil.ecommpoc.domain.model.homepage.HomePageModel
import io.reactivex.Flowable

interface AppDataSource {
    fun getHomePageData(): Flowable<HomePageEntity>
}