package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter


/**
 * Created by Vinícius Veríssimo on 23/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class FilterTagGenerator {
    fun generateTagFromStreamSpecifier(streamSpecifier: String?): String =
        streamSpecifier?.let { "[$it]" } ?: ""
}