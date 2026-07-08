package com.sounddrive.audio

import android.content.Context

class MultiTrackPlayer(
    private val context: Context
) {

    private val players =
        mutableMapOf<StemType, StemPlayer>()

    fun loadPack(
        soundPack: SoundPack
    ) {

        soundPack.stems.forEach {

            val player =
                StemPlayer(context)

            players[it.stemType] =
                player
        }
    }

    fun play() {

        players.values.forEach {
            it.play()
        }
    }

    fun pause() {

        players.values.forEach {
            it.pause()
        }
    }

    fun setStemVolume(
        stemType: StemType,
        volume: Float
    ) {

        players[stemType]
            ?.setVolume(volume)
    }

    fun release() {

        players.values.forEach {
            it.release()
        }
    }
}
