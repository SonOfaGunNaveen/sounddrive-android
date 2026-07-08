package com.sounddrive.audio

import com.sounddrive.telemetry.DrivingState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AdaptiveAudioEngine {

    private val _audioLayer =
        MutableStateFlow(AudioLayer())

    val audioLayer: StateFlow<AudioLayer>
        get() = _audioLayer

    fun update(
        drivingState: DrivingState
    ) {

        val drums =
            mapValue(
                drivingState.acceleration,
                0f,
                10f
            )

        val bass =
            mapValue(
                drivingState.speedKmh,
                0f,
                140f
            )

        val synth =
            mapValue(
                drivingState.speedKmh,
                40f,
                180f
            )

        val fx =
            mapValue(
                drivingState.corneringForce,
                0f,
                10f
            )

        _audioLayer.value =
            AudioLayer(
                drumsGain = drums,
                bassGain = bass,
                synthGain = synth,
                fxGain = fx
            )
    }

    private fun mapValue(
        value: Float,
        min: Float,
        max: Float
    ): Float {

        return ((value - min) / (max - min))
            .coerceIn(0f, 1f)
    }
}
