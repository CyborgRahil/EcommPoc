package com.rahil.ecommpoc.data.source

import com.rahil.ecommpoc.data.model.HomePageEntity
import com.rahil.ecommpoc.data.repository.AppDataSource
import com.rahil.ecommpoc.data.repository.AppRemote
import io.reactivex.Single
import javax.inject.Inject

class AppRemoteDataSource @Inject constructor(
    private val appRemote: AppRemote
) : AppDataSource {
    override fun getHomePageData(): Single<HomePageEntity> {
        return appRemote.getHomePageData()
    }

}