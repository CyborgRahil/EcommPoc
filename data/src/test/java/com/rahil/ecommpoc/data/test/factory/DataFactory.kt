package com.rahil.ecommpoc.data.test.factory

import java.util.*
import java.util.concurrent.ThreadLocalRandom

internal object DataFactory {

    fun randomString(): String {
        return UUID.randomUUID().toString()
    }

    fun randomInt(): Int {
        return ThreadLocalRandom.current().nextInt(0, 1000 + 1)
    }
}
