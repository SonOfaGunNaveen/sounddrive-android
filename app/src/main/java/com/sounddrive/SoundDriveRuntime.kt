package com.sounddrive

import com.sounddrive.audio.AdaptiveAudioEngine
import com.sounddrive.audio.DriveModeManager
import com.sounddrive.telemetry.DrivingAnalyzer

class SoundDriveRuntime {

    val drivingAnalyzer =
        DrivingAnalyzer()

    val adaptiveAudioEngine =
        AdaptiveAudioEngine()

    val driveModeManager =
        DriveModeManager()

    fun initialize() {

        drivingAnalyzer.update(
            speed = 0f,
            acceleration = 0f,
            cornering = 0f
        )
    }
}
