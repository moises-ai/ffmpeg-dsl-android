package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.assertion

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.exception.InvalidVolumeException


/**
 * Created by Vinícius Veríssimo on 05/07/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
object VolumeAssertion: Assertion<Number> {
    override fun assert(value: Number) {
        if (value.toInt() < 0) throw InvalidVolumeException()
    }
}