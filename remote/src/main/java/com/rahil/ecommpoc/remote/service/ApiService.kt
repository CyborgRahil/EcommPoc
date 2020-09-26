package com.rahil.ecommpoc.remote.service

import com.rahil.ecommpoc.data.model.HomePageEntity
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("/api/v1/getHomeData/")
    fun getHomePageData()
            : Single<HomePageEntity>
}
