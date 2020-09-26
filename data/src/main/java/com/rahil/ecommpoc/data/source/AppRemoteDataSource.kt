package com.rahil.ecommpoc.data.source

import com.rahil.ecommpoc.data.model.HomePageEntity
import com.rahil.ecommpoc.data.repository.AppDataSource
import com.rahil.ecommpoc.data.repository.AppRemote
import io.reactivex.Flowable
import javax.inject.Inject

class AppRemoteDataSource @Inject constructor(
    private val appRemote: AppRemote
) : AppDataSource {
    override fun getHomePageData(): Flowable<HomePageEntity> {
        return appRemote.getHomePageData()
    }

}