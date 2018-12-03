package com.juangm.locations_cleanarchitecture.presentation

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.juangm.locations_cleanarchitecture.R
import com.juangm.locations_cleanarchitecture.presentation.extensions.inflate
import com.juangm.locations_cleanarchitecture.presentation.models.UiLocation
import kotlin.properties.Delegates

class LocationsAdapter : RecyclerView.Adapter<LocationsAdapter.LocationsViewHolder>() {

    var items: List<UiLocation> by Delegates.observable(emptyList()) { _, _, _ -> notifyDataSetChanged() }

    inner class LocationsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val locationCoordinates: TextView = itemView.findViewById(R.id.locationCoordinates)
        val locationDate: TextView = itemView.findViewById(R.id.locationDate)

        @SuppressLint("SetTextI18n")
        fun bind(location: UiLocation) {
            with(location) {
                locationCoordinates.text = coordinates
                locationDate.text = date
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationsViewHolder =
        LocationsViewHolder(parent.inflate(R.layout.view_location_item))

    override fun onBindViewHolder(holder: LocationsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    internal fun setLocations(locations: List<UiLocation>) {
        this.items = locations
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size
}