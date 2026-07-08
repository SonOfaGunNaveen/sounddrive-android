package com.sounddrive.telemetry

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.math.abs

class SensorTelemetryManager(
    context: Context
) : SensorEventListener {

    private val sensorManager =
        context.getSystemService(
            Context.SENSOR_SERVICE
        ) as SensorManager

    private val _acceleration =
        MutableStateFlow(0f)

    private val _corneringForce =
        MutableStateFlow(0f)

    val acceleration: StateFlow<Float>
        get() = _acceleration

    val corneringForce: StateFlow<Float>
        get() = _corneringForce

    fun start() {

        sensorManager.registerListener(
            this,
            sensorManager.getDefaultSensor(
                Sensor.TYPE_ACCELEROMETER
            ),
            SensorManager.SENSOR_DELAY_GAME
        )
    }

    override fun onSensorChanged(
        event: SensorEvent
    ) {

        val x = event.values[0]
        val y = event.values[1]

        _corneringForce.value =
            abs(x)

        _acceleration.value =
            abs(y)
    }

    override fun onAccuracyChanged(
        sensor: Sensor?,
        accuracy: Int
    ) {
    }
}
