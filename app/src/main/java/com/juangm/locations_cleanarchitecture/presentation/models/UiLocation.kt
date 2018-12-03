package com.juangm.locations_cleanarchitecture.presentation.models

import com.juangm.locations_cleanarchitecture.domain.models.Location
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

data class UiLocation(val coordinates: String, val date: String)

fun Location.toPresentationModel(): UiLocation =
    UiLocation(
        "${latitude.toPrettifiedString()} | ${longitude.toPrettifiedString()}",
        date.toPrettifiedString()
    )

private fun Date.toPrettifiedString(): String =
    SimpleDateFormat.getDateTimeInstance().run { format(this@toPrettifiedString) }

private fun Double.toPrettifiedString(): String {

    val df = DecimalFormat("#.###")
    df.roundingMode = RoundingMode.CEILING

    return df.format(this)

}