package com.rahil.ecommpoc.presentation.homePage

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockito_kotlin.*
import com.rahil.ecommpoc.domain.interactor.homePage.GetHomePageData
import com.rahil.ecommpoc.domain.model.homepage.HomePageModel
import com.rahil.ecommpoc.presentation.test.factory.HomePageDataFactory
import io.reactivex.observers.DisposableSingleObserver
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class HomePagePresenterTest {

    private lateinit var mockHomePageView:HomePageContract.HomePageView
    private lateinit var mockGetHomePageData: GetHomePageData

    private lateinit var homePagePresenter: HomePageContract.HomePagePresenter
    private lateinit var captor:  KArgumentCaptor<DisposableSingleObserver<HomePageModel>>

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        captor = argumentCaptor()
        mockHomePageView = mock()
        mockGetHomePageData = mock()
        homePagePresenter = HomePagePresenter(mockHomePageView,
            mockGetHomePageData)
    }

    @Test
    fun retrieveHomePageDataHideErrorState() {
        homePagePresenter.start()

        verify(mockGetHomePageData).execute(captor.capture(),eq(null))
        captor.firstValue.onSuccess(HomePageDataFactory.makeHomePageData())
        verify(mockHomePageView).hideErrorState()
        verify(mockHomePageView).hideProgress()
    }

    @Test
    fun retrieveHomePageDataHidesEmptyState() {
        homePagePresenter.start()
        verify(mockHomePageView).hideEmptyState()
        verify(mockGetHomePageData).execute(captor.capture(), eq(null))
        captor.firstValue.onSuccess(HomePageDataFactory.makeHomePageData())
    }

    @Test
    fun retrieveHomePageData() {
        val homePageData = HomePageDataFactory.makeHomePageData()
        homePagePresenter.retrieveHomePageData()

        verify(mockGetHomePageData).execute(captor.capture(), eq(null))
        captor.firstValue.onSuccess(homePageData)
        verify(mockHomePageView).showHomeData(homePageData)
        verify(mockHomePageView).hideProgress()
    }
    
    @Test
    fun retrieveHomePageDataShowsErrorState() {
        homePagePresenter.retrieveHomePageData()

        verify(mockGetHomePageData).execute(captor.capture(), eq(null))
        captor.firstValue.onError(RuntimeException())
        verify(mockHomePageView).hideProgress()
        verify(mockHomePageView).showErrorState()
    }

    @Test
    fun retrieveHomePageDataWhenErrorThrown() {
        homePagePresenter.start()

        verify(mockGetHomePageData).execute(captor.capture(), eq(null))
        captor.firstValue.onError(RuntimeException())
        verify(mockHomePageView).hideProgress()
        verify(mockHomePageView).showErrorState()
    }
}