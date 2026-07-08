package com.sounddrive.audio

import com.sounddrive.telemetry.DrivingState

object DrivingIntensityMapper {

    fun map(
        state: DrivingState
    ): DrivingIntensity {

        return when {

            state.acceleration < 2f ->
                DrivingIntensity.LOW

            state.acceleration < 5f ->
                DrivingIntensity.MEDIUM

            state.acceleration < 8f ->
                DrivingIntensity.HIGH

            else ->
                DrivingIntensity.EXTREME
        }
    }
}
