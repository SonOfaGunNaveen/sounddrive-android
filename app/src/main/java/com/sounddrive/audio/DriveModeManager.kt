package com.sounddrive.audio

import com.sounddrive.telemetry.DrivingState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DriveModeManager {

    private val _audioMode =
        MutableStateFlow(AudioMode.AMBIENT)

    val audioMode: StateFlow<AudioMode>
        get() = _audioMode

    fun update(
        state: DrivingState
    ) {

        _audioMode.value = when {

            state.speedKmh < 20f ->
                AudioMode.AMBIENT

            state.speedKmh < 60f ->
                AudioMode.CRUISE

            state.speedKmh < 110f ->
                AudioMode.DYNAMIC

            state.speedKmh < 150f ->
                AudioMode.SPORT

            else ->
                AudioMode.RACE
        }
    }
}
