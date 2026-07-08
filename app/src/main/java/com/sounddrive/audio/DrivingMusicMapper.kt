package com.sounddrive.audio

import com.sounddrive.telemetry.DrivingState

object DrivingMusicMapper {

    fun describe(
        state: DrivingState
    ): String {

        return when {

            state.speedKmh < 20 ->
                "Ambient"

            state.speedKmh < 60 ->
                "Cruise"

            state.speedKmh < 100 ->
                "Dynamic"

            else ->
                "Sport"
        }
    }
}
