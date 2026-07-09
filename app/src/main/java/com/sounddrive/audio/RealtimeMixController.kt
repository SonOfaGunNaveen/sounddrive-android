package com.sounddrive.audio

import com.sounddrive.telemetry.DrivingState

class RealtimeMixController(

    private val mappingEngine: MappingEngine,

    private val dynamicMixEngine: DynamicMixEngine,

    private val driveModeManager: DriveModeManager
) {

    fun update(
        state: DrivingState
    ) {

        driveModeManager.update(
            state
        )

        val layer =
            mappingEngine.map(
                state
            )

        dynamicMixEngine.updateMix(
            layer,
            driveModeManager.audioMode.value
        )
    }
}
