package com.sounddrive.audio

object AdaptiveMixProfiles {

    val city =
        AdaptiveMixProfile(
            drumsMultiplier = 0.2f,
            bassMultiplier = 0.3f,
            padsMultiplier = 1.0f,
            arpMultiplier = 0.1f,
            fxMultiplier = 0.2f
        )

    val highway =
        AdaptiveMixProfile(
            drumsMultiplier = 0.5f,
            bassMultiplier = 0.8f,
            padsMultiplier = 0.6f,
            arpMultiplier = 0.3f,
            fxMultiplier = 0.3f
        )

    val sport =
        AdaptiveMixProfile(
            drumsMultiplier = 1.0f,
            bassMultiplier = 1.0f,
            padsMultiplier = 0.2f,
            arpMultiplier = 0.7f,
            fxMultiplier = 0.4f
        )

    val race =
        AdaptiveMixProfile(
            drumsMultiplier = 1.0f,
            bassMultiplier = 1.0f,
            padsMultiplier = 0.0f,
            arpMultiplier = 1.0f,
            fxMultiplier = 0.8f
        )
}
