package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.assertion

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.exception.InvalidTimeException
import java.util.concurrent.TimeUnit
import kotlin.math.abs


/**
 * Created by Vinícius Veríssimo on 28/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
abstract class TimeAssertion<T> : Assertion<T> {
    object MinutesAssertion: TimeAssertion<Int>() {
        override fun assert(value: Int) {
            if (value !in -59..59) {
                throw InvalidTimeException(TimeUnit.MINUTES, value)
            }
        }
    }

    object SecondsAssertion: TimeAssertion<Double>() {
        override fun assert(value: Double) {
            if(abs(value.toInt()) >= 60) {
                throw InvalidTimeException(TimeUnit.SECONDS, value)
            }
        }
    }
}