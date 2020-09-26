package com.rahil.ecommpoc.remote

import com.rahil.ecommpoc.data.model.HomePageEntity
import com.rahil.ecommpoc.data.repository.AppRemote
import com.rahil.ecommpoc.remote.service.ApiService
import io.reactivex.Single
import javax.inject.Inject

class AppRemoteImpl @Inject constructor(
    private val service: ApiService
) : AppRemote {
    override fun getHomePageData(): Single<HomePageEntity> {
        return service.getHomePageData()
    }
}
