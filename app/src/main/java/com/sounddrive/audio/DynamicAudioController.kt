package com.sounddrive.audio

import com.sounddrive.telemetry.DrivingState

class DynamicAudioController(

    private val player: DynamicStemPlayer
) {

    fun update(
        state: DrivingState
    ) {

        StemCategory.entries.forEach {

            val volume =
                CategoryMixer.volumeFor(
                    it,
                    state
                )

            player.setCategoryVolume(
                it,
                volume
            )
        }
    }
}
