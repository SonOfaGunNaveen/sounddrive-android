package com.sounddrive.telemetry

class DrivingSessionManager {

    private var maxSpeed = 0f

    fun update(
        state: DrivingState
    ) {

        if (state.speedKmh > maxSpeed) {

            maxSpeed = state.speedKmh
        }
    }

    fun getMaxSpeed(): Float {

        return maxSpeed
    }
}
