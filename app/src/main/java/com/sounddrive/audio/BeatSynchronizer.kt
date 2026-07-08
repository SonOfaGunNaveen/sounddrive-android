package com.sounddrive.audio

class BeatSynchronizer(

    private val bpm: Int = 120
) {

    fun getBeatDurationMs(): Long {

        return (
            60000f / bpm
        ).toLong()
    }

    fun getBarDurationMs(): Long {

        return getBeatDurationMs() * 4
    }
}
