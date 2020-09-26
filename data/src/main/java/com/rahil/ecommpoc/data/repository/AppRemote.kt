package com.rahil.ecommpoc.data.repository

import com.rahil.ecommpoc.data.model.HomePageEntity
import io.reactivex.Flowable

interface AppRemote {
    fun getHomePageData(): Flowable<HomePageEntity>
}
