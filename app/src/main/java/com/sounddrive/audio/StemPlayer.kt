package com.sounddrive.audio

import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import android.content.Context

class StemPlayer(
    context: Context
) {

    private val player =
        ExoPlayer.Builder(context)
            .build()

    fun load(
        assetUri: String
    ) {

        player.setMediaItem(
            MediaItem.fromUri(assetUri)
        )

        player.repeatMode =
            ExoPlayer.REPEAT_MODE_ONE

        player.prepare()
    }

    fun play() {
        player.play()
    }

    fun pause() {
        player.pause()
    }

    fun setVolume(
        volume: Float
    ) {

        player.volume =
            volume.coerceIn(0f, 1f)
    }

    fun release() {
        player.release()
    }
}
