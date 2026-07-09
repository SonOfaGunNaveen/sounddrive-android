package com.sounddrive.audio

object PresetRepository {

    fun getMatrix(
        preset: SoundDrivePreset
    ): MappingMatrix {

        return when (preset) {

            SoundDrivePreset.RELAXED ->
                MappingMatrix(
                    speedToBass = 0.7f,
                    accelerationToDrums = 0.5f,
                    corneringToFx = 0.5f
                )

            SoundDrivePreset.BALANCED ->
                MappingMatrix()

            SoundDrivePreset.AGGRESSIVE ->
                MappingMatrix(
                    speedToBass = 1.3f,
                    accelerationToDrums = 1.5f,
                    corneringToFx = 1.2f
                )
        }
    }
}
