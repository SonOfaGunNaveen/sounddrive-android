package com.sounddrive

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sounddrive.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(
    savedInstanceState: Bundle?
    ) {
    super.onCreate(savedInstanceState)

    setContentView(R.layout.activity_main)

    val engine =
        SoundDriveEngine()

    engine.start()

    RuntimeDiagnostics.dump()
    }
}
