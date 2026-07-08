package com.sounddrive.audio

class DynamicMixEngine {

    fun updateMix(
        layer: AudioLayer
    ) {

        val drumsVolume =
            layer.drumsGain

        val bassVolume =
            layer.bassGain

        val synthVolume =
            layer.synthGain

        val fxVolume =
            layer.fxGain

        println(
            """
            MIX UPDATE
            Drum=$drumsVolume
            Bass=$bassVolume
            Synth=$synthVolume
            FX=$fxVolume
            """.trimIndent()
        )
    }
}
