package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.assertion.StreamSpecifierAssertion


/**
 * Created by Vinícius Veríssimo on 25/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class MapArgument(streamSpecifier: String): Argument() {
    override val key: String = "-map"
    override val value: String = streamSpecifier

    init {
        StreamSpecifierAssertion.assert(streamSpecifier)
    }
}