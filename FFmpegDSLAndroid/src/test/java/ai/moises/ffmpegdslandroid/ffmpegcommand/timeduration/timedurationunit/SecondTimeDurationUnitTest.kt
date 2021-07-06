package ai.moises.ffmpegdslandroid.ffmpegcommand.timeduration.timedurationunit

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
 * Created by Vinícius Veríssimo on 30/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class SecondTimeDurationUnitTest {

    private val secondTimeDurationUnit = SecondTimeDurationUnit()

    @Test
    fun should_CorrectlyFormatTheValueToSecondsInString_when_ValueIsAPositiveValue() {
        val secondsInString = secondTimeDurationUnit.format(2f)

        assertThat(secondsInString).matches("2.0")
    }

    @Test
    fun should_CorrectlyFormatTheValueToSecondsInString_when_ValueIsANegativeValue() {
        val secondsInString = secondTimeDurationUnit.format(-10.5f)

        assertThat(secondsInString).matches("-10.5")
    }

    @Test
    fun should_KeepAllDecimalPartOnFormattedString_when_ValueIsALongDecimalValue() {
        val secondsInString = secondTimeDurationUnit.format(0.5123123123123)

        assertThat(secondsInString).matches("0.5123123123123")
    }
}