package com.rahil.ecommpoc.data

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import com.rahil.ecommpoc.data.mapper.HomePageDataMapper
import com.rahil.ecommpoc.data.model.HomePageEntity
import com.rahil.ecommpoc.data.repository.AppDataSource
import com.rahil.ecommpoc.data.source.AppDataSourceFactory
import com.rahil.ecommpoc.data.test.factory.HomePageDataFactory
import com.rahil.ecommpoc.domain.model.homepage.HomePageModel
import io.reactivex.Flowable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class AppDataRepositoryTest {

    private val mapper = mock<HomePageDataMapper>()
    private val factory = mock<AppDataSourceFactory>()
    private val store = mock<AppDataSource>()
    private val repository = AppDataRepository(factory, mapper)

    @Before
    fun setup() {
        stubFactoryGetDataSource()
    }

    @Test
    fun calling_GetHomePageData_ReturnsComplete() {
        stubHomePageData(Flowable.just(HomePageDataFactory.makeHomePageDataEntity()))
        stubMapper(HomePageDataFactory.makeHomePageDataModel(), any())

        val testObserver = repository.getHomePageData().test()
        testObserver.assertComplete()
    }

    @Test
    fun calling_GetHomePageData_ReturnsData() {
        val homePageEntity= HomePageDataFactory.makeHomePageDataEntity()
        val homePageModel = HomePageDataFactory.makeHomePageDataModel()
        stubHomePageData(Flowable.just(homePageEntity))
        stubMapper(homePageModel, homePageEntity)

        val testObserver = repository.getHomePageData().test()
        testObserver.assertValue(homePageModel)
    }

    private fun stubMapper(model: HomePageModel, entity: HomePageEntity) {
        whenever(mapper.mapFromEntity(entity)) doReturn model
    }

    private fun stubHomePageData(stub: Flowable<HomePageEntity>) {
        whenever(store.getHomePageData()) doReturn stub
    }

    private fun stubFactoryGetDataSource() {
        whenever(factory.getDataSource()) doReturn store
    }
}
