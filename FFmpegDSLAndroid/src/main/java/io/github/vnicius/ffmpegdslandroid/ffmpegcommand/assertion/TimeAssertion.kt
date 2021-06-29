package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.assertion

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.exception.InvalidTimeException
import java.util.concurrent.TimeUnit


/**
 * Created by Vinícius Veríssimo on 28/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
abstract class TimeAssertion<T> : Assertion<T> {
    object MinutesAssertion: TimeAssertion<Int>() {
        override fun assert(value: Int) {
            if (value !in -60..60) {
                throw InvalidTimeException(TimeUnit.MINUTES, value)
            }
        }
    }

    object SecondsAssertion: TimeAssertion<Float>() {
        override fun assert(value: Float) {
            if(value !in -60f..60f) {
                throw InvalidTimeException(TimeUnit.SECONDS, value)
            }
        }
    }
}