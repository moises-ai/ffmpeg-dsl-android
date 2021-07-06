package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.assertion

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.exception.InvalidGainListSize


/**
 * Created by Vinícius Veríssimo on 06/07/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
object GainAssertion: Assertion<FloatArray> {
    override fun assert(value: FloatArray) {
        if (value.isEmpty()) throw InvalidGainListSize()
    }
}