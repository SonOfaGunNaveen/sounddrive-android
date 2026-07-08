package com.sounddrive.audio

class DynamicMixEngine(
    private val player: MultiTrackPlayer
) {

    fun updateMix(
        layer: AudioLayer
    ) {

        player.setStemVolume(
            StemType.DRUMS,
            layer.drumsGain
        )

        player.setStemVolume(
            StemType.BASS,
            layer.bassGain
        )

        player.setStemVolume(
            StemType.SYNTH,
            layer.synthGain
        )

        player.setStemVolume(
            StemType.FX,
            layer.fxGain
        )
    }
}
