package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.streamspecifier.StreamSpecifier


/**
 * Created by Vinícius Veríssimo on 23/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class FilterTagGenerator {
    fun generateTagFromStreamSpecifier(streamSpecifier: StreamSpecifier?): String =
        streamSpecifier?.let { "[${it.parseToString()}]" } ?: ""
}