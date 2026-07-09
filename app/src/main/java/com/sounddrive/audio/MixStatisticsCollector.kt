package com.sounddrive.audio

class MixStatisticsCollector {

    private val drums =
        mutableListOf<Float>()

    private val bass =
        mutableListOf<Float>()

    private val synth =
        mutableListOf<Float>()

    private val fx =
        mutableListOf<Float>()

    fun add(
        layer: AudioLayer
    ) {

        drums.add(layer.drumsGain)

        bass.add(layer.bassGain)

        synth.add(layer.synthGain)

        fx.add(layer.fxGain)
    }

    fun getStatistics(): MixStatistics {

        return MixStatistics(

            averageDrums =
                drums.average()
                    .toFloat(),

            averageBass =
                bass.average()
                    .toFloat(),

            averageSynth =
                synth.average()
                    .toFloat(),

            averageFx =
                fx.average()
                    .toFloat()
        )
    }
}
