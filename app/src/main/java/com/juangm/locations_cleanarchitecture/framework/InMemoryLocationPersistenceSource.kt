package com.juangm.locations_cleanarchitecture.framework

import com.juangm.locations_cleanarchitecture.data.LocationPersistenceSource
import com.juangm.locations_cleanarchitecture.domain.models.Location

class InMemoryLocationPersistenceSource : LocationPersistenceSource {

    private var locations: List<Location> = emptyList()

    override fun getPersistedLocations(): List<Location> = locations

    override fun saveNewLocation(location: Location) {
        locations += location
    }
}