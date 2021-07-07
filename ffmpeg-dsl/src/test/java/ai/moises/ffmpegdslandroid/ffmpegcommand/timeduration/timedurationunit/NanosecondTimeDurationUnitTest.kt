package ai.moises.ffmpegdslandroid.ffmpegcommand.timeduration.timedurationunit

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
 * Created by Vinícius Veríssimo on 30/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class NanosecondTimeDurationUnitTest {
    private val nanosecondTimeDurationUnit = NanosecondTimeDurationUnit()

    @Test
    fun should_CorrectlyFormatTheValueToNanosecondsInString_when_ValueIsAPositiveValue() {
        val secondsInString = nanosecondTimeDurationUnit.format(2)

        assertThat(secondsInString).matches("2us")
    }

    @Test
    fun should_CorrectlyFormatTheValueToNanosecondsInString_when_ValueIsANegativeValue() {
        val secondsInString = nanosecondTimeDurationUnit.format(-10)

        assertThat(secondsInString).matches("-10us")
    }

    @Test
    fun should_CorrectlyFormatTheValueToNanosecondsInString_when_ValueIsADecimalNumber() {
        val secondsInString = nanosecondTimeDurationUnit.format(20.5f)

        assertThat(secondsInString).matches("20.5us")
    }

    @Test
    fun should_KeepAllDecimalPartOnFormattedString_when_ValueIsALongDecimalNumber() {
        val secondsInString = nanosecondTimeDurationUnit.format(0.5123123123123)

        assertThat(secondsInString).matches("0.5123123123123us")
    }
}