package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.assertion.StreamSpecifierAssertion
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.streamspecifier.StreamSpecifier


/**
 * Created by Vinícius Veríssimo on 25/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class MapArgument private constructor(): Argument() {
    override val key: String = "-map"
    override val value: String
        get() = valueString

    private var valueString: String = ""

    constructor(streamSpecifier: StreamSpecifier): this() {
        valueString = streamSpecifier.parseToString()
    }

    constructor(specifier: String): this() {
        StreamSpecifierAssertion.assert(specifier)

        valueString = specifier
    }
}