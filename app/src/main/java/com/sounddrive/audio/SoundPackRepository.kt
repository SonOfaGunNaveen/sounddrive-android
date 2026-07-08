package com.sounddrive.audio

class SoundPackRepository {

    fun getDefaultPack(): SoundPack {

        return SoundPack(

            id = "default",

            name = "Drive Ambient",

            stems = listOf(

                StemTrack(
                    id = "1",
                    name = "Drums",
                    fileName = "drums.mp3",
                    stemType = StemType.DRUMS
                ),

                StemTrack(
                    id = "2",
                    name = "Bass",
                    fileName = "bass.mp3",
                    stemType = StemType.BASS
                ),

                StemTrack(
                    id = "3",
                    name = "Synth",
                    fileName = "synth.mp3",
                    stemType = StemType.SYNTH
                ),

                StemTrack(
                    id = "4",
                    name = "FX",
                    fileName = "fx.mp3",
                    stemType = StemType.FX
                )
            )
        )
    }
}
