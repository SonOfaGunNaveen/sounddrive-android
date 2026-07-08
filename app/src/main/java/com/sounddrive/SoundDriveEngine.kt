package com.sounddrive

class SoundDriveEngine {

    private val runtime =
        SoundDriveRuntime()

    fun start() {

        runtime.initialize()

        AppLogger.log(
            "SoundDrive Runtime Initialized"
        )
    }
}
