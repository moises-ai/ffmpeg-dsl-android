package ai.moises.ffmpegdslandroid.ffmpegcommand.assertion

import ai.moises.ffmpegdslandroid.ffmpegcommand.exception.ValueIsBlankException


/**
 * Created by Vinícius Veríssimo on 19/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
object ValueAssertion: Assertion<String> {
    override fun assert(value: String) {
        if (value.isBlank()) throw ValueIsBlankException()
    }
}