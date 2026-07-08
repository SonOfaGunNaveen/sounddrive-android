package com.sounddrive

import android.util.Log

object AppLogger {

    private const val TAG =
        "SoundDrive"

    fun log(
        message: String
    ) {
        Log.d(TAG, message)
    }
}
