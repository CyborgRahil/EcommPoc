package com.rahil.ecommpoc.remote.test.factory

import com.rahil.ecommpoc.data.model.CategoryEntity
import com.rahil.ecommpoc.data.model.HomePageEntity
import com.rahil.ecommpoc.data.model.NewServiceEntity

object AppDataFactory {

    private fun makeCategoryData(): List<CategoryEntity> {
        return with(DataFactory) {
            listOf(CategoryEntity(randomInt(), randomString(), randomString()))
        }
    }

    private fun makeNewServiceData(): List<NewServiceEntity> {
            return with(DataFactory) {
                listOf(NewServiceEntity(randomInt(), randomString(), randomString(), randomString()))
        }
    }

    fun makeHomePageData(): HomePageEntity {
       return HomePageEntity(makeCategoryData(), makeCategoryData(), makeNewServiceData());
    }
}
