package com.sounddrive.audio

import com.sounddrive.telemetry.DrivingAnalyzer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AudioOrchestrator(

    private val analyzer: DrivingAnalyzer,

    private val adaptiveAudioEngine: AdaptiveAudioEngine,

    private val stemMixer: StemMixer
) {

    private val scope =
        CoroutineScope(Dispatchers.Default)

    fun start() {

        scope.launch {

            analyzer.state.collect { state ->

                adaptiveAudioEngine.update(
                    state
                )

            }
        }

        scope.launch {

            adaptiveAudioEngine.audioLayer
                .collect {

                    stemMixer.updateLayer(it)
                }
        }
    }
}
