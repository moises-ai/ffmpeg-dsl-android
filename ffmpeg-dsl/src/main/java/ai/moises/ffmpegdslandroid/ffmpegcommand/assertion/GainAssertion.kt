package ai.moises.ffmpegdslandroid.ffmpegcommand.assertion

import ai.moises.ffmpegdslandroid.ffmpegcommand.exception.InvalidGainListSize


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