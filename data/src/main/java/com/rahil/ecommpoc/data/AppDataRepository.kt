package com.rahil.ecommpoc.data

import com.rahil.ecommpoc.data.mapper.HomePageDataMapper
import com.rahil.ecommpoc.data.source.AppDataSourceFactory
import com.rahil.ecommpoc.domain.model.homepage.HomePageModel
import com.rahil.ecommpoc.domain.repository.AppRepository
import io.reactivex.Flowable
import javax.inject.Inject

class AppDataRepository @Inject constructor(
    private val factory: AppDataSourceFactory,
    private val homePageDataMapper: HomePageDataMapper
) : AppRepository {
    override fun getHomePageData(): Flowable<HomePageModel> {
        return factory.getDataSource().getHomePageData()
            .map { homePageEntity -> homePageDataMapper.mapFromEntity(homePageEntity)  }
    }
}

