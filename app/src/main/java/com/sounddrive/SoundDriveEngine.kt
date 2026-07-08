package com.sounddrive

import com.sounddrive.audio.AdaptiveAudioEngine
import com.sounddrive.audio.AudioOrchestrator
import com.sounddrive.audio.StemMixer
import com.sounddrive.telemetry.DrivingAnalyzer

class SoundDriveEngine {

    private val analyzer =
        DrivingAnalyzer()

    private val adaptiveEngine =
        AdaptiveAudioEngine()

    private val stemMixer =
        StemMixer()

    private val audioOrchestrator =
        AudioOrchestrator(
            analyzer,
            adaptiveEngine,
            stemMixer
        )

    fun start() {

        audioOrchestrator.start()
    }
}
