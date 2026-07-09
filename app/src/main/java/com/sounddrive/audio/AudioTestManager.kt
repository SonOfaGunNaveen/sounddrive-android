package com.sounddrive.audio

import android.content.Context
import com.sounddrive.R

class AudioTestManager(
    context: Context
) {

    private val player =
        StemPlayer(context)

    private var loaded = false

    fun start() {

        if (!loaded) {

            player.loadResource(
                R.raw.drums
            )

            loaded = true
        }

        player.play()
    }

    fun setDrumIntensity(
        intensity: Float
    ) {

        player.setVolume(
            intensity.coerceIn(
                0f,
                1f
            )
        )
    }

    fun stop() {

        player.pause()
    }
}
