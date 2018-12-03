package com.juangm.locations_cleanarchitecture.data

import com.juangm.locations_cleanarchitecture.domain.models.Location

interface LocationPersistenceSource {

    fun getPersistedLocations(): List<Location>
    fun saveNewLocation(location: Location)
}