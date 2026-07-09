package com.sounddrive

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.sounddrive.audio.AudioMode
import com.sounddrive.audio.MappingEngine
import com.sounddrive.audio.AudioTestManager
import com.sounddrive.telemetry.DrivingState
import com.sounddrive.telemetry.SimulationEngine
import com.sounddrive.telemetry.SimulationMode
import com.sounddrive.ui.DashboardController


class MainActivity : AppCompatActivity() {

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
                findViewById(R.id.txtFx)
            )

        val simulationEngine =
            SimulationEngine()

        val mappingEngine =
            MappingEngine()

        val audioTestManager =
            MultiStemTestManager(this)

        fun update(mode: SimulationMode) {

            val state =
                simulationEngine.generate(mode)

            val layer =mappingEngine.map(state)

                audioManager.applyLayer(layer)

            audioTestManager.setDrumIntensity(
            layer.drumsGain)

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
            update(SimulationMode.CITY)
        }

        findViewById<Button>(
            R.id.btnHighway
        ).setOnClickListener {
            update(SimulationMode.HIGHWAY)
        }

        findViewById<Button>(
            R.id.btnSport
        ).setOnClickListener {
            update(SimulationMode.SPORT)
        }

        findViewById<Button>(
            R.id.btnRace
        ).setOnClickListener {
            update(SimulationMode.RACE)
        }

        findViewById<Button>(
        R.id.btnPlay
        ).setOnClickListener {

        audioTestManager.start()
        }

        findViewById<Button>(
            R.id.btnStop
        ).setOnClickListener {

            audioTestManager.stop()
        }    

        update(
            SimulationMode.CITY
        )
    }
}
