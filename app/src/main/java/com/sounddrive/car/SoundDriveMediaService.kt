package com.sounddrive.car

import androidx.media3.session.MediaSession
import androidx.media3.session.MediaSessionService
import com.sounddrive.audio.PlayerManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SoundDriveMediaService : MediaSessionService() {

    @Inject
    lateinit var playerManager: PlayerManager

    private var mediaSession: MediaSession? = null

    override fun onCreate() {
        super.onCreate()

        mediaSession =
            MediaSession.Builder(
                this,
                playerManager.getPlayer()
            ).build()
    }

    override fun onGetSession(
        controllerInfo: MediaSession.ControllerInfo
    ): MediaSession? {

        return mediaSession
    }

    override fun onDestroy() {

        mediaSession?.release()

        playerManager.release()

        super.onDestroy()
    }
}
