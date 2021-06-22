package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.assertion

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.exception.CodecNotSupportedException


/**
 * Created by Vinícius Veríssimo on 21/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
object CodecAssertion: Assertion<String> {
    override fun assert(value: String) {
        if (value.isBlank()) throw CodecNotSupportedException(value)
    }
}