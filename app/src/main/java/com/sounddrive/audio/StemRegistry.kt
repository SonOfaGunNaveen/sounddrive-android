package com.sounddrive.audio

object StemRegistry {

    val stems =
        StemScanner.scan()

    fun byCategory(
        category: StemCategory
    ): List<StemDefinition> {

        return stems.filter {

            it.category == category
        }
    }
}
