package com.rahil.ecommpoc.data.repository

import com.rahil.ecommpoc.data.model.HomePageEntity
import io.reactivex.Single

interface AppDataSource {
    fun getHomePageData(): Single<HomePageEntity>
}