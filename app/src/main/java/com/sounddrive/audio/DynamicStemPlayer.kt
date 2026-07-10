package com.sounddrive.audio

import android.content.Context

class DynamicStemPlayer(
    context: Context
) {

    private val players =
        mutableMapOf<StemDefinition, StemPlayer>()

    init {

        StemRegistry.stems.forEach {

            players[it] =
                StemPlayer(context)
        }
    }

    fun start() {

        players.forEach { (stem, player) ->

            player.loadResource(
                stem.resourceId
            )

            player.play()
        }
    }

    fun stop() {

        players.values.forEach {
            it.pause()
        }
    }

    fun setCategoryVolume(
        category: StemCategory,
        volume: Float
    ) {

        players.forEach { (stem, player) ->

            if (stem.category == category) {

                player.setVolume(volume)
            }
        }
    }
}
