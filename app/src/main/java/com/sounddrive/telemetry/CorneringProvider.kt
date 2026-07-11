package com.sounddrive.telemetry

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import kotlin.math.abs

class CorneringProvider(
    context: Context
) : SensorEventListener {

    private val sensorManager =
        context.getSystemService(
            Context.SENSOR_SERVICE
        ) as SensorManager

    private var listener:
        ((Float) -> Unit)? = null

    fun start(
        callback: (Float) -> Unit
    ) {

        listener = callback

        sensorManager.registerListener(
            this,
            sensorManager.getDefaultSensor(
                Sensor.TYPE_GYROSCOPE
            ),
            SensorManager.SENSOR_DELAY_GAME
        )
    }

    fun stop() {

        sensorManager.unregisterListener(
            this
        )
    }

    override fun onSensorChanged(
        event: SensorEvent
    ) {

        val z =
            abs(event.values[2])

        listener?.invoke(z)
    }

    override fun onAccuracyChanged(
        sensor: Sensor?,
        accuracy: Int
    ) {
    }
}
