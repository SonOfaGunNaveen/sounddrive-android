package com.sounddrive.audio

class StemMixer {

    private var drumsGain = 0f

    private var bassGain = 0f

    private var synthGain = 0f

    private var fxGain = 0f

    fun updateLayer(
        layer: AudioLayer
    ) {

        drumsGain = layer.drumsGain

        bassGain = layer.bassGain

        synthGain = layer.synthGain

        fxGain = layer.fxGain

        logCurrentMix()
    }

    private fun logCurrentMix() {

        println(
            """
            Drums : $drumsGain
            Bass  : $bassGain
            Synth : $synthGain
            FX    : $fxGain
            """.trimIndent()
        )
    }
}
