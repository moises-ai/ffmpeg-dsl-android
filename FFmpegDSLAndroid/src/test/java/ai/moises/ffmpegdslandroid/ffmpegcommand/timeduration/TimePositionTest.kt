package ai.moises.ffmpegdslandroid.ffmpegcommand.timeduration

import com.google.common.truth.Truth.assertThat
import ai.moises.ffmpegdslandroid.ffmpegcommand.exception.InvalidTimeException
import org.junit.Test

/**
 * Created by Vinícius Veríssimo on 30/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class TimePositionTest {

    @Test
    fun should_CorrectlyFormatTimePosition_when_TimePositionOnlyContainsSecondsLessThanTen() {
        val timePosition = TimePosition(2.0)

        val formattedTimePosition = timePosition.format()

        assertThat(formattedTimePosition).matches("00:02")
    }

    @Test
    fun should_CorrectlyFormatTimePosition_when_TimePositionOnlyContainsSecondsGreaterThanTen() {
        val timePosition = TimePosition(22.0)

        val formattedTimePosition = timePosition.format()

        assertThat(formattedTimePosition).matches("00:22")
    }

    @Test
    fun should_CorrectlyFormatTimePosition_when_TimePositionContainsSecondsWithLongDecimalValue() {
        val timePosition = TimePosition(12.1412412323)

        val formattedTimePosition = timePosition.format()

        assertThat(formattedTimePosition).matches("00:12.1412412323")
    }

    @Test
    fun should_CorrectlyFormatTimePosition_when_TimePositionOnlyContainsMinutesLessThanTen() {
        val timePosition = TimePosition(2,0.0)

        val formattedTimePosition = timePosition.format()

        assertThat(formattedTimePosition).matches("02:00")
    }

    @Test
    fun should_CorrectlyFormatTimePosition_when_TimePositionOnlyContainsMinutesGreaterThanTen() {
        val timePosition = TimePosition(11,0.0)

        val formattedTimePosition = timePosition.format()

        assertThat(formattedTimePosition).matches("11:00")
    }

    @Test
    fun should_CorrectlyFormatTimePosition_when_TimePositionOnlyContainsHoursLessThanTen() {
        val timePosition = TimePosition(8, 0,0.0)

        val formattedTimePosition = timePosition.format()

        assertThat(formattedTimePosition).matches("08:00:00")
    }

    @Test
    fun should_CorrectlyFormatTimePosition_when_TimePositionOnlyContainsHoursGreaterThanTen() {
        val timePosition = TimePosition(90, 0,0.0)

        val formattedTimePosition = timePosition.format()

        assertThat(formattedTimePosition).matches("90:00:00")
    }

    @Test
    fun should_CorrectlyFormatTimePosition_when_TimePositionContainsMinutesAndSeconds() {
        val timePosition = TimePosition(0, 22,5.0)

        val formattedTimePosition = timePosition.format()

        assertThat(formattedTimePosition).matches("22:05")
    }

    @Test
    fun should_CorrectlyFormatTimePosition_when_TimePositionContainsNegativeHours() {
        val timePosition = TimePosition(-1, 45,5.0)

        val formattedTimePosition = timePosition.format()

        assertThat(formattedTimePosition).matches("-01:45:05")
    }

    @Test
    fun should_CorrectlyFormatTimePosition_when_TimePositionContainsNegativeSeconds() {
        val timePosition = TimePosition(0, 0,-5.0)

        val formattedTimePosition = timePosition.format()

        assertThat(formattedTimePosition).matches("-00:05")
    }


    @Test
    fun should_CorrectlyFormatTimePosition_when_TimePositionContainsNegativeMinutes() {
        val timePosition = TimePosition(-2,12.0)

        val formattedTimePosition = timePosition.format()

        assertThat(formattedTimePosition).matches("-02:12")
    }

    @Test(expected = InvalidTimeException::class)
    fun should_Fails_when_TimePositionContainsNegativeMinutesAndHours() {
        TimePosition(12, -2,12.0)
    }

    @Test(expected = InvalidTimeException::class)
    fun should_Fails_when_TimePositionContainsNegativeSecondsAndMinutes() {
        TimePosition(2,-12.0)
    }

    @Test(expected = InvalidTimeException::class)
    fun should_Fails_when_TimePositionContainsNegativeSecondsAndHours() {
        TimePosition(2, 0,-12.0)
    }

    // The minutes should be a value between -59 and +59
    @Test(expected = InvalidTimeException::class)
    fun should_Fails_when_TimePositionContainsMinutesOutOfNegativeValueBoundary() {
        TimePosition(-60, 0.0)
    }

    // The minutes should be a value between -59 and +59
    @Test(expected = InvalidTimeException::class)
    fun should_Fails_when_TimePositionContainsMinutesOutOfPositiveValueBoundary() {
        TimePosition(60, 0.0)
    }

    // The seconds should be a value between -59 and +59
    @Test(expected = InvalidTimeException::class)
    fun should_Fails_when_TimePositionContainsSecondsOutOfNegativeValueBoundary() {
        TimePosition(-100.0)
    }

    // The seconds should be a value between -59 and +59
    @Test(expected = InvalidTimeException::class)
    fun should_Fails_when_TimePositionContainsSecondsOutOfPositiveValueBoundary() {
        TimePosition(100.0)
    }
}