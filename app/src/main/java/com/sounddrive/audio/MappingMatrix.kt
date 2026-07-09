package com.sounddrive.audio

data class MappingMatrix(

    val speedToBass: Float = 1f,

    val accelerationToDrums: Float = 1f,

    val corneringToFx: Float = 1f,

    val brakingToFilter: Float = 1f
)
