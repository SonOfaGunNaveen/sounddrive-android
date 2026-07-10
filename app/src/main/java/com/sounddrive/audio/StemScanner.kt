package com.sounddrive.audio

import com.sounddrive.R

object StemScanner {

    fun scan(): List<StemDefinition> {

        return R.raw::class.java.fields
            .map { field ->

                val name =
                    field.name.lowercase()

                StemDefinition(

                    resourceId =
                        field.getInt(null),

                    fileName =
                        name,

                    category =
                        classify(name)
                )
            }
    }

    private fun classify(
        fileName: String
    ): StemCategory {

        return when {

            fileName.startsWith("drums") ->
                StemCategory.DRUMS

            fileName.startsWith("kick") ->
                StemCategory.KICK

            fileName.startsWith("bass") ->
                StemCategory.BASS

            fileName.startsWith("pads") ->
                StemCategory.PADS

            fileName.startsWith("synth") ->
                StemCategory.SYNTH

            fileName.startsWith("arp") ->
                StemCategory.ARP

            fileName.startsWith("fx") ->
                StemCategory.FX

            fileName.startsWith("vocals") ->
                StemCategory.VOCALS

            else ->
                StemCategory.UNKNOWN
        }
    }
}
