package ai.moises.ffmpegdslandroid.ffmpegcommand.timeduration

import com.google.common.truth.Truth.assertThat
import ai.moises.ffmpegdslandroid.ffmpegcommand.timeduration.timedurationunit.MillisecondTimeDurationUnit
import ai.moises.ffmpegdslandroid.ffmpegcommand.timeduration.timedurationunit.NanosecondTimeDurationUnit
import ai.moises.ffmpegdslandroid.ffmpegcommand.timeduration.timedurationunit.SecondTimeDurationUnit
import org.junit.Test

/**
 * Created by Vinícius Veríssimo on 30/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class SimpleTimeDurationTest {

    @Test
    fun should_FormatTimeDurationValueBasedOnTimeDurationUnit_when_TimeDurationUnitIsInSeconds() {
        val simpleTimeDuration = SimpleTimeDuration(2f, SecondTimeDurationUnit())

        val formattedTimeDuration = simpleTimeDuration.format()

        assertThat(formattedTimeDuration).matches("2.0")
    }

    @Test
    fun should_FormatTimeDurationValueBasedOnTimeDurationUnit_when_TimeDurationUnitIsInMilliseconds() {
        val simpleTimeDuration = SimpleTimeDuration(200, MillisecondTimeDurationUnit())

        val formattedTimeDuration = simpleTimeDuration.format()

        assertThat(formattedTimeDuration).matches("200ms")
    }

    @Test
    fun should_FormatTimeDurationValueBasedOnTimeDurationUnit_when_TimeDurationUnitIsInNanoseconds() {
        val simpleTimeDuration = SimpleTimeDuration(200, NanosecondTimeDurationUnit())

        val formattedTimeDuration = simpleTimeDuration.format()

        assertThat(formattedTimeDuration).matches("200us")
    }
}