package com.rahil.ecommpoc.appUi.injection.module

import androidx.multidex.BuildConfig
import com.rahil.ecommpoc.appUi.homePage.MainActivity
import com.rahil.ecommpoc.appUi.homePage.fragment.HomeFragment
import com.rahil.ecommpoc.domain.interactor.homePage.GetHomePageData
import com.rahil.ecommpoc.presentation.homePage.HomePageContract
import com.rahil.ecommpoc.presentation.homePage.HomePagePresenter
import com.rahil.ecommpoc.remote.service.ApiService
import com.rahil.ecommpoc.remote.service.ApiServiceFactory
import dagger.Binds

import dagger.Module
import dagger.Provides


/**
 * Module that provides all dependencies from the presentation package/layer.
 */
@Module
abstract class PresentationModule

