package com.rahil.ecommpoc.data.source

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import com.rahil.ecommpoc.data.model.HomePageEntity
import com.rahil.ecommpoc.data.repository.AppRemote
import com.rahil.ecommpoc.data.test.factory.HomePageDataFactory
import io.reactivex.Flowable
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class AppRemoteDataSourceTest {

    private val remote = mock<AppRemote>()
    private val store = AppRemoteDataSource(remote)

    @Test
    fun calling_GetHomePageData_ReturnsComplete() {
        stubRemoteGetHomePageData(Flowable.just(HomePageDataFactory.makeHomePageDataEntity()))
        val testObserver = store.getHomePageData().test()
        testObserver.assertComplete()
    }

    @Test
    fun calling_GetHomePageData_ReturnsData() {
        val data = HomePageDataFactory.makeHomePageDataEntity()
        stubRemoteGetHomePageData(Flowable.just(data))
        val testObserver = store.getHomePageData().test()
        testObserver.assertValue(data)
    }

    private fun stubRemoteGetHomePageData(stub: Flowable<HomePageEntity>) {
        whenever(remote.getHomePageData()) doReturn stub
    }
}
