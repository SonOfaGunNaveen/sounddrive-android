package com.sounddrive.telemetry

class TelemetryFusionEngine {

    private var speed = 0f

    private var acceleration = 0f

    private var cornering = 0f

    fun updateSpeed(
        value: Float
    ) {
        speed = value
    }

    fun updateAcceleration(
        value: Float
    ) {
        acceleration = value
    }

    fun updateCornering(
        value: Float
    ) {
        cornering = value
    }

    fun currentState(): DrivingState {

        return DrivingState(
            speedKmh = speed,
            acceleration = acceleration,
            corneringForce = cornering
        )
    }
}
