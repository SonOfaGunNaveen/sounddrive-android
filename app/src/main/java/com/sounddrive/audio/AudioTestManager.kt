package com.sounddrive.audio

import android.content.Context
import com.sounddrive.R

class AudioTestManager(
    context: Context
) {

    private val player =
        StemPlayer(context)

    fun playDrums() {

        player.loadResource(
            R.raw.drums
        )

        player.setVolume(0.5f)

        player.play()
    }

    fun stop() {

        player.pause()
    }
}
