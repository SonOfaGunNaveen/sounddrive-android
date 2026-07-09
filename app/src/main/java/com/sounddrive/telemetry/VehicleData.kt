package com.sounddrive.telemetry

data class VehicleData(

    val speed: Float = 0f,

    val rpm: Int = 0,

    val throttle: Float = 0f,

    val engineLoad: Float = 0f,

    val coolantTemp: Float = 0f,

    val fuelLevel: Float = 0f,

    val intakeTemp: Float = 0f
)
