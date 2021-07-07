package ai.moises.ffmpegdslandroid.ffmpegcommand.filter

import ai.moises.ffmpegdslandroid.ffmpegcommand.streamspecifier.StreamSpecifier


/**
 * Created by Vinícius Veríssimo on 23/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class FilterTagGenerator {
    fun generateTagFromStreamSpecifier(streamSpecifier: StreamSpecifier?): String =
        streamSpecifier?.let { "[${it.parseToString()}]" } ?: ""
}