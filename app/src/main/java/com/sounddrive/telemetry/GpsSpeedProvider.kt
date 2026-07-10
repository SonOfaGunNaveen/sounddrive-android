package com.sounddrive.telemetry

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager

class GpsSpeedProvider(
    private val context: Context
) {

    private var speedListener:
        ((Float) -> Unit)? = null

    @SuppressLint("MissingPermission")
    fun start(
        listener: (Float) -> Unit
    ) {

        speedListener = listener

        val locationManager =
            context.getSystemService(
                Context.LOCATION_SERVICE
            ) as LocationManager

        locationManager.requestLocationUpdates(
            LocationManager.GPS_PROVIDER,
            1000L,
            1f,
            object : LocationListener {

                override fun onLocationChanged(
                    location: Location
                ) {

                    val speedKmh =
                        location.speed * 3.6f

                    speedListener?.invoke(
                        speedKmh
                    )
                }
            }
        )
    }
}
