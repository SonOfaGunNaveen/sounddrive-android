package com.sounddrive.audio

data class PlaybackState(

    val currentBpm: Int = 120,

    val currentMode: AudioMode =
        AudioMode.AMBIENT,

    val currentBar: Long = 0
)
`
