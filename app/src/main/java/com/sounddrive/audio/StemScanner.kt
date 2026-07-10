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

            fileName.contains("drums") ->
                StemCategory.DRUMS

            fileName.contains("kick") ->
                StemCategory.KICK

            fileName.contains("bass") ->
                StemCategory.BASS

            fileName.contains("pads") ->
                StemCategory.PADS

            fileName.contains("synth") ->
                StemCategory.SYNTH

            fileName.contains("arp") ->
                StemCategory.ARP

            fileName.contains("fx") ->
                StemCategory.FX

            fileName.contains("vocals") ->
                StemCategory.VOCALS

            else ->
                StemCategory.UNKNOWN
        }
    }
}
