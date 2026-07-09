package com.sounddrive.ui

data class TelemetrySnapshot(

    val speed: Float = 0f,

    val acceleration: Float = 0f,

    val cornering: Float = 0f,

    val driveMode: String = "AMBIENT"
)
