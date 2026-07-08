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

    players.clear()

    soundPack.stems.forEach { stem ->

        val player =
            StemPlayer(context)

        player.loadResource(
            stem.resourceId
        )

        when (stem.stemType) {

            StemType.DRUMS ->
                player.setVolume(0.3f)

            StemType.BASS ->
                player.setVolume(0.3f)

            StemType.SYNTH ->
                player.setVolume(0.2f)

            StemType.FX ->
                player.setVolume(0.1f)

            StemType.PADS ->
                player.setVolume(0.2f)

            StemType.VOCALS ->
                player.setVolume(0.0f)
        }

        players[stem.stemType] = player
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
