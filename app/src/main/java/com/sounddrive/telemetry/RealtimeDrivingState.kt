package com.sounddrive.telemetry

data class RealtimeDrivingState(

    val speedKmh: Float,

    val acceleration: Float,

    val cornering: Float
)
