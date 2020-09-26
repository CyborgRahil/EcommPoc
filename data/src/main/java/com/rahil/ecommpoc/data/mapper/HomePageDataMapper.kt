package com.rahil.ecommpoc.data.mapper

import com.rahil.ecommpoc.data.model.CategoryEntity
import com.rahil.ecommpoc.data.model.HomePageEntity
import com.rahil.ecommpoc.data.model.NewServiceEntity
import com.rahil.ecommpoc.domain.model.homepage.CategoryModel
import com.rahil.ecommpoc.domain.model.homepage.HomePageModel
import com.rahil.ecommpoc.domain.model.homepage.NewServiceModel
import javax.inject.Inject

class HomePageDataMapper @Inject constructor() : EntityMapper<HomePageEntity, HomePageModel> {

    override fun mapFromEntity(entity: HomePageEntity): HomePageModel {
        val featuredCategoryList: List<CategoryModel> = entity.featured.map {
                entity ->  CategoryModel(entity.id, entity.name, entity.image)
        }

        val featureSubCategoryList: List<CategoryModel> = entity.categories.map {
                entity ->  CategoryModel(entity.id, entity.name, entity.image)
        }

        val newFeatureList: List<NewServiceModel> = entity.what_new.map {
                entity ->  NewServiceModel(entity.id, entity.title, entity.description, entity.image)
        }
        return HomePageModel(
           featuredCategoryList, featureSubCategoryList, newFeatureList
        )
    }

    override fun mapToEntity(homePageModel: HomePageModel): HomePageEntity {
        val featuredCategoryList: List<CategoryEntity> = homePageModel.featured.map {
                entity ->  CategoryEntity(entity.id, entity.name, entity.image)
        }

        val featureSubCategoryList: List<CategoryEntity> = homePageModel.categories.map {
                entity ->  CategoryEntity(entity.id, entity.name, entity.image)
        }

        val newFeatureList: List<NewServiceEntity> = homePageModel.what_new.map {
                entity ->  NewServiceEntity(entity.id, entity.title, entity.description, entity.image)
        }
        return HomePageEntity(
            featuredCategoryList, featureSubCategoryList, newFeatureList
        )
    }
}