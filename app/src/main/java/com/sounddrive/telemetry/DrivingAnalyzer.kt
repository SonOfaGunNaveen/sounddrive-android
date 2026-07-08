package com.sounddrive.telemetry

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DrivingAnalyzer {

    private val _drivingState =
        MutableStateFlow(
            DrivingState()
        )

    val state: StateFlow<DrivingState>
        get() = _drivingState

    fun update(

        speed: Float,

        acceleration: Float,

        cornering: Float
    ) {

        _drivingState.value =
            DrivingState(
                speedKmh = speed,

                acceleration = acceleration,

                braking =
                    if (acceleration < 0f)
                        -acceleration
                    else
                        0f,

                corneringForce =
                    cornering
            )
    }
}
