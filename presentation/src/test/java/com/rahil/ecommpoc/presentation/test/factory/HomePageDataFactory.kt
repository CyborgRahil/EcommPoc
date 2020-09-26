package com.rahil.ecommpoc.presentation.test.factory

import com.rahil.ecommpoc.domain.model.homepage.CategoryModel
import com.rahil.ecommpoc.domain.model.homepage.HomePageModel
import com.rahil.ecommpoc.domain.model.homepage.NewServiceModel

class HomePageDataFactory {

    companion object Factory {

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

}