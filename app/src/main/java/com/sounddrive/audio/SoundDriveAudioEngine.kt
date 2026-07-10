package com.sounddrive.audio

import android.content.Context
import com.sounddrive.R

class MultiStemTestManager(
    context: Context
) {

    private val drums = StemPlayer(context)
    private val bass = StemPlayer(context)
    private val synth = StemPlayer(context)
    private val fx = StemPlayer(context)

    private var loaded = false

    fun start() {

        if (!loaded) {

            drums.loadResource(R.raw.drums)
            bass.loadResource(R.raw.bass)
            synth.loadResource(R.raw.synth)
            fx.loadResource(R.raw.fx)

            loaded = true
        }

        drums.play()
        bass.play()
        synth.play()
        fx.play()
    }

    fun applyLayer(
        layer: AudioLayer
    ) {

        drums.setVolume(layer.drumsGain)
        bass.setVolume(layer.bassGain)
        synth.setVolume(layer.synthGain)
        fx.setVolume(layer.fxGain)
    }

    fun stop() {

        drums.pause()
        bass.pause()
        synth.pause()
        fx.pause()
    }
}
