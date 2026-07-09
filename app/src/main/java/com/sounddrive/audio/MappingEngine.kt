package com.sounddrive.audio

import com.sounddrive.telemetry.DrivingState

class MappingEngine(

    private val matrix: MappingMatrix =
        MappingMatrix()
) {

    fun map(
        state: DrivingState
    ): AudioLayer {

        return AudioLayer(

            drumsGain =
                (state.acceleration / 10f)
                    * matrix.accelerationToDrums,

            bassGain =
                (state.speedKmh / 140f)
                    * matrix.speedToBass,

            synthGain =
                (state.speedKmh / 180f),

            fxGain =
                (state.corneringForce / 10f)
                    * matrix.corneringToFx
        )
    }
}
