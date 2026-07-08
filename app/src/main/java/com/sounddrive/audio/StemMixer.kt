package com.sounddrive.audio

class StemMixer {

    fun updateLayer(
        layer: AudioLayer
    ) {

        println(
            "Drums=${layer.drumsGain}," +
            " Bass=${layer.bassGain}," +
            " Synth=${layer.synthGain}," +
            " FX=${layer.fxGain}"
        )
    }
}
