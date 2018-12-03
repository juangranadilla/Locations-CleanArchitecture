package com.juangm.locations_cleanarchitecture.data

import com.juangm.locations_cleanarchitecture.domain.models.Location

interface DeviceLocationSource {

    fun getDeviceLocation(): Location
}