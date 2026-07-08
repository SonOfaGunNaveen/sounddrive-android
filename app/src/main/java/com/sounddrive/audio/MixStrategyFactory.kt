package com.sounddrive.audio

object MixStrategyFactory {

    fun create(
        mode: AudioMode
    ): MixStrategy {

        return MixStrategy(
            audioMode = mode,
            profile =
                AudioProfileRepository
                    .getProfile(mode)
        )
    }
}
