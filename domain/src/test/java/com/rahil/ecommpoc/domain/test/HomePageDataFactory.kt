@file:Suppress("MemberVisibilityCanBePrivate")

package com.rahil.poc.domain.test

import com.rahil.ecommpoc.domain.model.homepage.CategoryModel
import com.rahil.ecommpoc.domain.model.homepage.HomePageModel
import com.rahil.ecommpoc.domain.model.homepage.NewServiceModel
import com.rahil.ecommpoc.domain.test.DataFactory
import java.util.*

internal object HomePageDataFactory {

    fun randomString() = UUID.randomUUID().toString()

    private fun makeCategoryData(): List<CategoryModel> {
        return with(DataFactory) {
            listOf(CategoryModel(randomInt(), randomString(), randomString()))
        }
    }

    fun makeNewServiceData(): List<NewServiceModel> {
        return with(DataFactory) {
           listOf(
                NewServiceModel(
                    randomInt(),
                    randomString(),
                    randomString(),
                    randomString()
                )
            )
        }
    }

    fun makeHomePageData(): HomePageModel {
        return HomePageModel(makeCategoryData(), makeCategoryData(), makeNewServiceData());
    }
}