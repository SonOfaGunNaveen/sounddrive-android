package com.sounddrive.telemetry

class DebugTelemetryGenerator {

    private var speed = 0f

    fun nextState(): DrivingState {

        speed += 10f

        if (speed > 160f) {
            speed = 0f
        }

        return DrivingState(
            speedKmh = speed,
            acceleration = speed / 20f,
            corneringForce = speed / 50f
        )
    }
}
``
