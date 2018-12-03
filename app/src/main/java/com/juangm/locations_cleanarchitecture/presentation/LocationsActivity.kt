package com.juangm.locations_cleanarchitecture.presentation

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.juangm.locations_cleanarchitecture.R
import kotlinx.android.synthetic.main.activity_locations.*

class LocationsActivity : AppCompatActivity() {

    private val locationsAdapter = LocationsAdapter()
    private lateinit var locationsViewModel: LocationsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_locations)

        recycler.adapter = locationsAdapter
        recycler.layoutManager = LinearLayoutManager(this)

        locationsViewModel = ViewModelProviders.of(this).get(LocationsViewModel::class.java)
        locationsViewModel.locations.observe(this, Observer { locations ->
            locations?.let{
                locationsAdapter.setLocations(locations)
            }
        })

        newLocationBtn.setOnClickListener {
            locationsViewModel.newLocationClicked()
        }
    }
}
