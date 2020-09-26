package com.rahil.ecommpoc.domain.interactor.homepage

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.rahil.ecommpoc.domain.executor.PostExecutionThread
import com.rahil.ecommpoc.domain.executor.ThreadExecutor
import com.rahil.ecommpoc.domain.interactor.homePage.GetHomePageData
import com.rahil.ecommpoc.domain.model.homepage.HomePageModel
import com.rahil.ecommpoc.domain.repository.AppRepository
import com.rahil.ecommpoc.domain.test.HomePageDataFactory
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

class GetHomePageDataTest {

    private lateinit var getHomePageData: GetHomePageData
    private val appRepository: AppRepository = mock()
    private val postExecutionThread: PostExecutionThread = mock()
    private val threadExecutor: ThreadExecutor = mock()


    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        getHomePageData = GetHomePageData(appRepository, threadExecutor, postExecutionThread)
    }

    @Test
    fun buildUseCaseObservableCallsRepository() {
        getHomePageData.buildUseCaseObservable(null)
        verify(appRepository).getHomePageData()
    }

    @Test
    fun calling_GetHomePageData_ReturnsComplete() {
        stubHomePageData(Single.just(HomePageDataFactory.makeHomePageData()))
        val testObserver = getHomePageData.buildUseCaseObservable().test()
        testObserver.assertComplete()
    }

    @Test
    fun calling_GetHomePageData_ReturnsData() {
        val homePageData = HomePageDataFactory.makeHomePageData()
        stubHomePageData(Single.just(homePageData))
        val testObserver = getHomePageData.buildUseCaseObservable().test()
        testObserver.assertValue(homePageData)
    }

    private fun stubHomePageData(observable: Single<HomePageModel>) {
        whenever(appRepository.getHomePageData()).doReturn(observable)
    }
}