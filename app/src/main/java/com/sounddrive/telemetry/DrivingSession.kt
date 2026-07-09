package com.sounddrive.telemetry

data class DrivingSession(

    val startTimestamp: Long,

    val endTimestamp: Long? = null,

    val maxSpeed: Float = 0f,

    val averageSpeed: Float = 0f,

    val distanceKm: Float = 0f
)
