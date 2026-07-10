package com.sounddrive.audio

import com.sounddrive.telemetry.DrivingState

object CategoryMixer {

    fun volumeFor(
        category: StemCategory,
        state: DrivingState
    ): Float {

        return when (category) {

            StemCategory.DRUMS ->
                (state.acceleration / 10f)
                    .coerceIn(0f, 1f)

            StemCategory.KICK ->
                (state.acceleration / 10f)
                    .coerceIn(0f, 1f)

            StemCategory.BASS ->
                (state.speedKmh / 140f)
                    .coerceIn(0f, 1f)

            StemCategory.PADS ->
                (1f -
                        (state.speedKmh / 140f))
                    .coerceIn(0f, 1f)

            StemCategory.FX ->
                (state.corneringForce / 10f)
                    .coerceIn(0f, 1f)

            StemCategory.ARP ->
                (state.speedKmh / 180f)
                    .coerceIn(0f, 1f)

            StemCategory.SYNTH ->
                (state.speedKmh / 180f)
                    .coerceIn(0f, 1f)

            StemCategory.VOCALS ->
                0.5f

            StemCategory.UNKNOWN ->
                0f
        }
    }
}
