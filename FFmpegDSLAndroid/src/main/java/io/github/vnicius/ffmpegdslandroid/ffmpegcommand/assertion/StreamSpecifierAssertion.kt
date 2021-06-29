package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.assertion

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.exception.StreamSpecifierIsBlankException


/**
 * Created by Vinícius Veríssimo on 29/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
object StreamSpecifierAssertion: Assertion<String> {
    override fun assert(value: String) {
        if (value.isBlank()) throw StreamSpecifierIsBlankException()
    }
}