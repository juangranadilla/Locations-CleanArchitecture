package com.juangm.locations_cleanarchitecture.framework

import com.juangm.locations_cleanarchitecture.data.DeviceLocationSource
import com.juangm.locations_cleanarchitecture.domain.models.Location
import java.util.*

class FakeLocationSource : DeviceLocationSource {

    private val random = Random(System.currentTimeMillis())

    override fun getDeviceLocation(): Location =
        Location(
            random.nextDouble() * 180 - 90,
            random.nextDouble() * 360 - 180,
            Date()
        )
}