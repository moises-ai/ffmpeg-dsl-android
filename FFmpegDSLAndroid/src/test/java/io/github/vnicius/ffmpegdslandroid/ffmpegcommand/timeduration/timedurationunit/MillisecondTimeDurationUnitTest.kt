package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.timeduration.timedurationunit

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
 * Created by Vinícius Veríssimo on 30/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class MillisecondTimeDurationUnitTest {
    private val millisecondTimeDurationUnit = MillisecondTimeDurationUnit()

    @Test
    fun should_CorrectlyFormatTheValueToMillisecondsInString_when_ValueIsAPositiveValue() {
        val secondsInString = millisecondTimeDurationUnit.format(2)

        assertThat(secondsInString).matches("2ms")
    }

    @Test
    fun should_CorrectlyFormatTheValueToMillisecondsInString_when_ValueIsANegativeValue() {
        val secondsInString = millisecondTimeDurationUnit.format(-10)

        assertThat(secondsInString).matches("-10ms")
    }

    @Test
    fun should_CorrectlyFormatTheValueToMillisecondsInString_when_ValueIsADecimalNumber() {
        val secondsInString = millisecondTimeDurationUnit.format(20.5f)

        assertThat(secondsInString).matches("20.5ms")
    }

    @Test
    fun should_KeepAllDecimalPartOnFormattedString_when_ValueIsALongDecimalNumber() {
        val secondsInString = millisecondTimeDurationUnit.format(0.5123123123123)

        assertThat(secondsInString).matches("0.5123123123123ms")
    }
}