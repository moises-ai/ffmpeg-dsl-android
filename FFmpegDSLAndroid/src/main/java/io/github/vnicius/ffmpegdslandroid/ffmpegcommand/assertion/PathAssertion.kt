package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.assertion

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.exception.PathIsBlankException


/**
 * Created by Vinícius Veríssimo on 19/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class PathAssertion: Assertion<String> {
    override fun assert(value: String) {
        if (value.isBlank()) throw PathIsBlankException()
    }
}