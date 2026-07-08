package com.sounddrive.audio

import com.sounddrive.telemetry.DrivingState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DriveModeManager {

private var currentMode =
    AudioMode.AMBIENT

fun update(
    state: DrivingState
) {

    val newMode = when {

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

    if (newMode != currentMode) {

        currentMode = newMode

        _audioMode.value = newMode
    }
}
}
