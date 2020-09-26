package com.rahil.ecommpoc.data.source

import com.nhaarman.mockito_kotlin.mock
import org.junit.Test
import kotlin.test.assertEquals

class HomePageDataSourceFactoryTest {

    private val remoteStore = mock<AppRemoteDataSource>()
    private val factory = AppDataSourceFactory(remoteStore)

    @Test
    fun getDataSourceReturnsRemoteStore() {
        assertEquals(remoteStore, factory.getDataSource())
    }
}
