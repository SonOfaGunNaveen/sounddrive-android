package com.sounddrive.car

import androidx.media3.session.MediaSession
import androidx.media3.session.MediaSessionService

class SoundDriveMediaService : MediaSessionService() {

    private var mediaSession: MediaSession? = null

    override fun onGetSession(
        controllerInfo: MediaSession.ControllerInfo
    ): MediaSession? {
        return mediaSession
    }
}
