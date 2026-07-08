package com.sounddrive.audio

class AudioRepository {

    fun getTracks(): List<AudioTrack> {

        return listOf(

            AudioTrack(
                id = "1",
                title = "Drive Ambient",
                url = "https://samplelib.com/lib/preview/mp3/sample-3s.mp3"
            ),

            AudioTrack(
                id = "2",
                title = "Drive Energy",
                url = "https://samplelib.com/lib/preview/mp3/sample-6s.mp3"
            )
        )
    }
}
``
