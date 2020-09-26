package com.rahil.ecommpoc.data.mapper

import com.rahil.ecommpoc.data.model.HomePageEntity
import com.rahil.ecommpoc.data.test.factory.HomePageDataFactory
import com.rahil.ecommpoc.domain.model.homepage.HomePageModel
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class HomePageDataMapperTest {

    private val mapper = HomePageDataMapper()

    @Test
    fun mapFromEntityMapsData() {
        val entity = HomePageDataFactory.makeHomePageDataEntity()
        val model = mapper.mapFromEntity(entity)
        assertEqualData(entity, model)
    }

    @Test
    fun mapToEntityMapData() {
        val model = HomePageDataFactory.makeHomePageDataModel()
        val entity = mapper.mapToEntity(model)
        assertEqualData(entity, model)
    }

    private fun assertEqualData(entity: HomePageEntity, model: HomePageModel) {
        assertEquals(entity.featured.get(0).id , model.featured.get(0).id)
        assertEquals(entity.featured.get(0).name , model.featured.get(0).name)
        assertEquals(entity.featured.get(0).image , model.featured.get(0).image)
        assertEquals(entity.categories.get(0).id , model.categories.get(0).id)
        assertEquals(entity.categories.get(0).name , model.categories.get(0).name)
        assertEquals(entity.categories.get(0).image , model.categories.get(0).image)
        assertEquals(entity.what_new.get(0).id , model.what_new.get(0).id)
        assertEquals(entity.what_new.get(0).title , model.what_new.get(0).title)
        assertEquals(entity.what_new.get(0).image , model.what_new.get(0).image)
        assertEquals(entity.what_new.get(0).description , model.what_new.get(0).description)

    }
}
