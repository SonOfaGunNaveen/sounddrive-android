package com.sounddrive.audio

class DynamicMixEngine(
    private val player: MultiTrackPlayer
) {

    fun updateMix(
        layer: AudioLayer,
        mode: AudioMode
    ) {

        val profile =
            AudioProfileRepository
                .getProfile(mode)

        player.setStemVolume(
            StemType.DRUMS,
            layer.drumsGain *
                    profile.drumsMultiplier
        )

        player.setStemVolume(
            StemType.BASS,
            layer.bassGain *
                    profile.bassMultiplier
        )

        player.setStemVolume(
            StemType.SYNTH,
            layer.synthGain *
                    profile.synthMultiplier
        )

        player.setStemVolume(
            StemType.FX,
            layer.fxGain *
                    profile.fxMultiplier
        )
    }
}
