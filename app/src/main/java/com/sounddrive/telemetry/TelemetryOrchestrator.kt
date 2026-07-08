package com.sounddrive.telemetry

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect

class TelemetryOrchestrator(
    private val speedManager: SpeedManager,
    private val sensorManager: SensorTelemetryManager,
    private val analyzer: DrivingAnalyzer
) {

    private val scope =
        CoroutineScope(Dispatchers.Default)

    fun start() {

        speedManager.start()
        sensorManager.start()

        scope.launch {

            combine(
                speedManager.speed,
                sensorManager.acceleration,
                sensorManager.corneringForce
            ) { speed, acceleration, cornering ->

                Triple(
                    speed,
                    acceleration,
                    cornering
                )
            }.collect {

                analyzer.update(
                    speed = it.first,
                    acceleration = it.second,
                    cornering = it.third
                )
            }
        }
    }
}
