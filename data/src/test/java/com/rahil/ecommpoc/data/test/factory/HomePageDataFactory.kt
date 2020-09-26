package com.rahil.ecommpoc.data.test.factory

import com.rahil.ecommpoc.data.model.CategoryEntity
import com.rahil.ecommpoc.data.model.HomePageEntity
import com.rahil.ecommpoc.data.model.NewServiceEntity
import com.rahil.ecommpoc.domain.model.homepage.CategoryModel
import com.rahil.ecommpoc.domain.model.homepage.HomePageModel
import com.rahil.ecommpoc.domain.model.homepage.NewServiceModel

internal object HomePageDataFactory {

    fun makeHomePageDataEntity(): HomePageEntity {
        return with(DataFactory) {
            HomePageEntity(
                listOf(CategoryEntity(randomInt(), randomString(), randomString())),
                listOf(CategoryEntity(randomInt(), randomString(), randomString())),
                listOf(NewServiceEntity(randomInt(), randomString(), randomString(), randomString()))

            )
        }
    }

    fun makeHomePageDataModel(): HomePageModel {
        return with(DataFactory) {
            HomePageModel(
                listOf(CategoryModel(randomInt(), randomString(), randomString())),
                listOf(CategoryModel(randomInt(), randomString(), randomString())),
                listOf(NewServiceModel(randomInt(), randomString(), randomString(), randomString()))

            )
        }
    }
}