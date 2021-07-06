package ai.moises.ffmpegdslandroid.ffmpegcommand.assertion

import ai.moises.ffmpegdslandroid.ffmpegcommand.exception.KeyIsBlankException


/**
 * Created by Vinícius Veríssimo on 19/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
object KeyAssertion: Assertion<String> {
    override fun assert(value: String) {
        if (value.isBlank()) throw KeyIsBlankException()
    }
}