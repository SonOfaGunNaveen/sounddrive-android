package com.sounddrive.audio

import com.sounddrive.R

class SoundPackRepository {

    fun getDefaultPack(): SoundPack {

        return SoundPack(

            id = "default",

            name = "Drive Ambient",

            stems = listOf(

                StemTrack(
                    id = "1",
                    name = "Drums",
                    resourceId = R.raw.drums,
                    stemType = StemType.DRUMS
                ),

                StemTrack(
                    id = "2",
                    name = "Bass",
                    resourceId = R.raw.bass,
                    stemType = StemType.BASS
                ),

                StemTrack(
                    id = "3",
                    name = "Synth",
                    resourceId = R.raw.synth,
                    stemType = StemType.SYNTH
                ),

                StemTrack(
                    id = "4",
                    name = "FX",
                    resourceId = R.raw.fx,
                    stemType = StemType.FX
                )
            )
        )
    }
}
