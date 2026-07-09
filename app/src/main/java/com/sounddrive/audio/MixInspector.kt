package com.sounddrive.audio

object MixInspector {

    fun inspect(
        layer: AudioLayer
    ): String {

        return """
            Drums=${layer.drumsGain}
            Bass=${layer.bassGain}
            Synth=${layer.synthGain}
            FX=${layer.fxGain}
        """.trimIndent()
    }
}
