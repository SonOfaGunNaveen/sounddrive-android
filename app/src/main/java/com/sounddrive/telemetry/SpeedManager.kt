package com.sounddrive.telemetry

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SpeedManager(
    context: Context
) : LocationListener {

    private val locationManager =
        context.getSystemService(
            Context.LOCATION_SERVICE
        ) as LocationManager

    private val _speed =
        MutableStateFlow(0f)

    val speed: StateFlow<Float>
        get() = _speed

    @SuppressLint("MissingPermission")
    fun start() {

        locationManager.requestLocationUpdates(
            LocationManager.GPS_PROVIDER,
            1000L,
            0f,
            this
        )
    }

    override fun onLocationChanged(
        location: Location
    ) {

        _speed.value =
            location.speed * 3.6f
    }
}
