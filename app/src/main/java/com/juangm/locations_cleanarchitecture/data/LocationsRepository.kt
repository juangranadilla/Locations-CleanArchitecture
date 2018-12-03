package com.juangm.locations_cleanarchitecture.data

import com.juangm.locations_cleanarchitecture.domain.models.Location

class LocationsRepository(
    private val locationPersistenceSource: LocationPersistenceSource,
    private val deviceLocationSource: DeviceLocationSource) {

    fun getSavedLocations(): List<Location> = locationPersistenceSource.getPersistedLocations()

    fun requestNewLocation(): List<Location> {
        val newLocation = deviceLocationSource.getDeviceLocation()
        locationPersistenceSource.saveNewLocation(newLocation)
        return getSavedLocations()
    }
}