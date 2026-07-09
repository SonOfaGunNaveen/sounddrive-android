package com.sounddrive.audio

object AudioTransitionRepository {

    fun get(
        mode: AudioMode
    ): AudioTransitionProfile {

        return when (mode) {

            AudioMode.AMBIENT ->
                AudioTransitionProfile(
                    3000,
                    90
                )

            AudioMode.CRUISE ->
                AudioTransitionProfile(
                    2500,
                    110
                )

            AudioMode.DYNAMIC ->
                AudioTransitionProfile(
                    2000,
                    125
                )

            AudioMode.SPORT ->
                AudioTransitionProfile(
                    1500,
                    135
                )

            AudioMode.RACE ->
                AudioTransitionProfile(
                    1000,
                    150
                )
        }
    }
}
