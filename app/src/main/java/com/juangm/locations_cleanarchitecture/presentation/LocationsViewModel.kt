package com.juangm.locations_cleanarchitecture.presentation

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.juangm.locations_cleanarchitecture.data.LocationsRepository
import com.juangm.locations_cleanarchitecture.domain.usecases.GetLocationsUseCase
import com.juangm.locations_cleanarchitecture.domain.usecases.RequestNewLocationUseCase
import com.juangm.locations_cleanarchitecture.framework.FakeLocationSource
import com.juangm.locations_cleanarchitecture.framework.InMemoryLocationPersistenceSource
import com.juangm.locations_cleanarchitecture.presentation.models.UiLocation
import com.juangm.locations_cleanarchitecture.presentation.models.toPresentationModel

class LocationsViewModel(application: Application): AndroidViewModel(application) {

    private val _locations = MutableLiveData<List<UiLocation>>()
    val locations: LiveData<List<UiLocation>>
        get() = _locations

    private val persistence = InMemoryLocationPersistenceSource()
    private val deviceLocation = FakeLocationSource()
    private val locationsRepository = LocationsRepository(persistence, deviceLocation)

    private val getLocationsUseCase = GetLocationsUseCase(locationsRepository)
    private val requestNewLocationUseCase = RequestNewLocationUseCase(locationsRepository)

    init {
        val dataLocations = getLocationsUseCase()
        val uiLocations = dataLocations.map { it.toPresentationModel() }
        _locations.value = uiLocations
    }

    fun newLocationClicked() {
        val dataLocations = requestNewLocationUseCase()
        val uiLocations = dataLocations.map { it.toPresentationModel() }
        _locations.value = uiLocations
    }
}