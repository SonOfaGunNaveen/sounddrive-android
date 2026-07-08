package com.sounddrive.audio

import kotlinx.coroutines.delay

class CrossfadeEngine {

    suspend fun fade(
        start: Float,
        end: Float,
        durationMs: Long,
        onUpdate: (Float) -> Unit
    ) {

        val steps = 20

        val delta =
            (end - start) / steps

        repeat(steps) {

            val current =
                start + delta * it

            onUpdate(current)

            delay(
                durationMs / steps
            )
        }

        onUpdate(end)
    }
}
