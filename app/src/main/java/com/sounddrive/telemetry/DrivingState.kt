package com.sounddrive.telemetry

data class DrivingState(

    val speedKmh: Float = 0f,

    val acceleration: Float = 0f,

    val braking: Float = 0f,

    val corneringForce: Float = 0f
)
