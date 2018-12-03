package com.juangm.locations_cleanarchitecture.domain.usecases

import com.juangm.locations_cleanarchitecture.data.LocationsRepository
import com.juangm.locations_cleanarchitecture.domain.models.Location

class RequestNewLocationUseCase(private val locationsRepository: LocationsRepository) {

    operator fun invoke(): List<Location> = locationsRepository.requestNewLocation()

}