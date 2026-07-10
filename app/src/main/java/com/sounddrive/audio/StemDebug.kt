package com.sounddrive.audio

object StemDebug {

    fun printAll() {

        StemRegistry.stems.forEach {

            println(
                "${it.fileName} -> ${it.category}"
            )
        }
    }
}
