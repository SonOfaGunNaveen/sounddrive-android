package com.sounddrive.audio

object AudioProfileRepository {

    fun getProfile(
        mode: AudioMode
    ): AudioProfile {

        return when (mode) {

            AudioMode.AMBIENT ->
                AudioProfile(
                    0.2f,
                    0.4f,
                    0.3f,
                    0.7f
                )

            AudioMode.CRUISE ->
                AudioProfile(
                    0.5f,
                    0.6f,
                    0.5f,
                    0.5f
                )

            AudioMode.DYNAMIC ->
                AudioProfile(
                    0.8f,
                    0.8f,
                    0.7f,
                    0.4f
                )

            AudioMode.SPORT ->
                AudioProfile(
                    1.0f,
                    0.9f,
                    0.9f,
                    0.3f
                )

            AudioMode.RACE ->
                AudioProfile(
                    1.2f,
                    1.0f,
                    1.0f,
                    0.2f
                )
        }
    }
}
