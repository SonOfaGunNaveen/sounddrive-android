package com.sounddrive.audio

import com.sounddrive.telemetry.DrivingState

class TransitionEngine {

    fun detectMode(
        state: DrivingState
    ): AudioMode {

        return when {

            state.speedKmh < 20f ->
                AudioMode.AMBIENT

            state.speedKmh < 60f ->
                AudioMode.CRUISE

            state.speedKmh < 120f ->
                AudioMode.DYNAMIC

            else ->
                AudioMode.SPORT
        }
    }
}
