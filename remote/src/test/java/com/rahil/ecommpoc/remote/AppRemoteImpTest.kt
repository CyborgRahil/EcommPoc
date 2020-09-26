package com.rahil.ecommpoc.remote

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.rahil.ecommpoc.data.model.HomePageEntity
import com.rahil.ecommpoc.remote.service.ApiService
import com.rahil.ecommpoc.remote.test.factory.AppDataFactory
import io.reactivex.Flowable
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class AppRemoteImpTest {

    private val service = mock<ApiService>()
    private val remote = AppRemoteImpl(service)

    @Test
    fun getHomePageDataFromNetwork() {
        stubAppServiceRepositories(
            Flowable.just(
                AppDataFactory.makeHomePageData()
            )
        )

        val testObserver = remote.getHomePageData().test()
        testObserver.assertComplete()
    }

    @Test
    fun checkRestApiCallWhenCallingGetHomePageData() {
        stubAppServiceRepositories(
            Flowable.just(
                AppDataFactory.makeHomePageData()
            )
        )

        remote.getHomePageData().test()
        verify(service).getHomePageData()
    }

    private fun stubAppServiceRepositories(stub: Flowable<HomePageEntity>) {
        whenever(service.getHomePageData()) doReturn stub
    }
}