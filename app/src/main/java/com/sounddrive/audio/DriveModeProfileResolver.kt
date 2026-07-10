package com.sounddrive.audio

import com.sounddrive.telemetry.SimulationMode

object DriveModeProfileResolver {

    fun profile(
        mode: SimulationMode
    ): AdaptiveMixProfile {

        return when (mode) {

            SimulationMode.CITY ->
                AdaptiveMixProfiles.city

            SimulationMode.HIGHWAY ->
                AdaptiveMixProfiles.highway

            SimulationMode.SPORT ->
                AdaptiveMixProfiles.sport

            SimulationMode.RACE ->
                AdaptiveMixProfiles.race
        }
    }
}
