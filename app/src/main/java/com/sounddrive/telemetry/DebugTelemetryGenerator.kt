package com.sounddrive.telemetry

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DebugTelemetryGenerator {

    private val _state =
        MutableStateFlow(
            DrivingState()
        )

    val state: StateFlow<DrivingState>
        get() = _state

    fun simulate() {

        _state.value =
            DrivingState(
                speedKmh = 80f,
                acceleration = 4f,
                corneringForce = 2f
            )
    }
}
