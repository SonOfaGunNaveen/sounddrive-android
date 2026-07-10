package com.sounddrive.ui

import android.widget.TextView
import com.sounddrive.audio.AudioLayer
import com.sounddrive.audio.AudioMode
import com.sounddrive.telemetry.DrivingState

class DashboardController(

    private val speedView: TextView,

    private val modeView: TextView,

    private val drumsView: TextView,

    private val bassView: TextView,

    private val synthView: TextView,

    private val fxView: TextView,

    private val profileView: TextView
) {

    fun update(
        state: DrivingState,
        layer: AudioLayer,
        mode: AudioMode
    ) {

        speedView.text =
            "Speed: ${state.speedKmh}"

        modeView.text =
            "Mode: $mode"

        drumsView.text =
            "Drums: ${layer.drumsGain}"

        bassView.text =
            "Bass: ${layer.bassGain}"

        synthView.text =
            "Synth: ${layer.synthGain}"

        fxView.text =
            "FX: ${layer.fxGain}"

        profileView.text =
            "Profile: $mode"
    }
}
