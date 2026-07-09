package com.sounddrive.audio

import com.sounddrive.telemetry.DrivingState

object SignalMapper {

    fun map(
        state: DrivingState
    ): AudioLayer {

        return AudioLayer(

            drumsGain =
                (state.acceleration / 10f)
                    .coerceIn(0f, 1f),

            bassGain =
                (state.speedKmh / 140f)
                    .coerceIn(0f, 1f),

            synthGain =
                (state.speedKmh / 180f)
                    .coerceIn(0f, 1f),

            fxGain =
                (state.corneringForce / 10f)
                    .coerceIn(0f, 1f)
        )
    }
}
