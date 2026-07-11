package com.sounddrive

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.sounddrive.audio.AudioMode
import com.sounddrive.audio.DynamicAudioController
import com.sounddrive.audio.DynamicStemPlayer
import com.sounddrive.audio.MappingEngine
import com.sounddrive.audio.StemDebug
import com.sounddrive.telemetry.GpsSpeedProvider
import com.sounddrive.telemetry.SimulationEngine
import com.sounddrive.telemetry.SimulationMode
import com.sounddrive.ui.DashboardController
import com.sounddrive.telemetry.DrivingState
import com.sounddrive.telemetry.AccelerationProvider
import com.sounddrive.telemetry.CorneringProvider
import com.sounddrive.telemetry.TelemetryFusionEngine


class MainActivity : AppCompatActivity() {

    private val locationRequestCode = 1001

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_main
        )

        val dashboard =
            DashboardController(
                findViewById(R.id.txtSpeed),
                findViewById(R.id.txtMode),
                findViewById(R.id.txtDrums),
                findViewById(R.id.txtBass),
                findViewById(R.id.txtSynth),
                findViewById(R.id.txtFx),
                findViewById(R.id.txtProfile)
            )

        val simulationEngine =
            SimulationEngine()

        val mappingEngine =
            MappingEngine()

        val stemPlayer =
            DynamicStemPlayer(this)

        val audioController =
            DynamicAudioController(
                stemPlayer
            )

            var audioStarted = false
                    val gpsProvider =
                GpsSpeedProvider(this)
            
            val accelerationProvider =
                AccelerationProvider(this)
            
            val corneringProvider =
                CorneringProvider(this)
            
            val telemetryFusionEngine =
                TelemetryFusionEngine()

     //   stemPlayer.start()

        StemDebug.printAll()

        

        if (
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {

            gpsProvider.start { speed ->

            telemetryFusionEngine.updateSpeed(
                speed
            )
        
            runOnUiThread {
        
                findViewById<TextView>(
                    R.id.txtSpeed
                ).text =
                    "Speed: ${speed.toInt()} km/h"
            }
        }


        } else {

            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION
                ),
                locationRequestCode
            )
        }

                accelerationProvider.start {
        
                        telemetryFusionEngine
                            .updateAcceleration(it)
                    }

                corneringProvider.start {
            
                telemetryFusionEngine
                    .updateCornering(it)
            }


        fun update(
            mode: SimulationMode
        ) {

            if (!audioStarted) {

                stemPlayer.start()

            audioStarted = true
        }

            val state =
                simulationEngine.generate(
                    mode
                )

            val layer =
                mappingEngine.map(
                    state
                )

            audioController.update(
                state
            )

            val audioMode =
                when (mode) {

                    SimulationMode.CITY ->
                        AudioMode.AMBIENT

                    SimulationMode.HIGHWAY ->
                        AudioMode.CRUISE

                    SimulationMode.SPORT ->
                        AudioMode.SPORT

                    SimulationMode.RACE ->
                        AudioMode.RACE
                }

            dashboard.update(
                state,
                layer,
                audioMode
            )
        }

        findViewById<Button>(
            R.id.btnCity
        ).setOnClickListener {

                    val initialState =
            DrivingState()
        
        val initialLayer =
            mappingEngine.map(
                initialState
            )
        
        dashboard.update(
            initialState,
            initialLayer,
            AudioMode.AMBIENT
            )
        }

        findViewById<Button>(
            R.id.btnHighway
        ).setOnClickListener {

            update(
                SimulationMode.HIGHWAY
            )
        }

        findViewById<Button>(
            R.id.btnSport
        ).setOnClickListener {

            update(
                SimulationMode.SPORT
            )
        }

        findViewById<Button>(
            R.id.btnRace
        ).setOnClickListener {

            update(
                SimulationMode.RACE
            )
        }

        update(
            SimulationMode.CITY
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {

        super.onRequestPermissionsResult(
            requestCode,
            permissions,
            grantResults
        )

        if (
            requestCode == locationRequestCode &&
            grantResults.isNotEmpty() &&
            grantResults[0] ==
            PackageManager.PERMISSION_GRANTED
        ) {

            recreate()
        }
    }
}
