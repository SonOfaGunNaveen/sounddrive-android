package com.sounddrive.audio

import android.content.Context
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer

class PlayerManager(
    private val context: Context
) {

    private val player: ExoPlayer =
        ExoPlayer.Builder(context)
            .build()

    fun getPlayer(): ExoPlayer {
        return player
    }

    fun play(url: String) {

        player.setMediaItem(
            MediaItem.fromUri(url)
        )

        player.prepare()

        player.play()
    }

    fun pause() {
        player.pause()
    }

    fun stop() {
        player.stop()
    }

    fun release() {
        player.release()
    }
}
