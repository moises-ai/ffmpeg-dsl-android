package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument

import com.google.common.truth.Truth.assertThat
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.timeduration.TimeDurationBuilder
import org.junit.Test

/**
 * Created by Vinícius Veríssimo on 29/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class InputTimeOffsetArgumentTest {

    private val timeDurationBuilder = TimeDurationBuilder()

    @Test
    fun should_ParseArgumentCorrectly_when_TimeDurationIsInSeconds() {
        val timedDurationSeconds = timeDurationBuilder.toSecond(2.0)
        val inputTimeOffsetArgument = InputTimeOffsetArgument(timedDurationSeconds)

        val parsedArgument = inputTimeOffsetArgument.parseToString()

        assertThat(parsedArgument).matches("-itsoffset \"2.0\"")
    }

    @Test
    fun should_ParseArgumentCorrectly_when_TimeDurationIsInMilliseconds() {
        val timedDurationSeconds = timeDurationBuilder.toMillisecond(200)
        val inputTimeOffsetArgument = InputTimeOffsetArgument(timedDurationSeconds)

        val parsedArgument = inputTimeOffsetArgument.parseToString()

        assertThat(parsedArgument).matches("-itsoffset \"200ms\"")
    }

    @Test
    fun should_ParseArgumentCorrectly_when_TimeDurationIsInNanoseconds() {
        val timedDurationSeconds = timeDurationBuilder.toNanosecond(200)
        val inputTimeOffsetArgument = InputTimeOffsetArgument(timedDurationSeconds)

        val parsedArgument = inputTimeOffsetArgument.parseToString()

        assertThat(parsedArgument).matches("-itsoffset \"200us\"")
    }

    @Test
    fun should_ParseArgumentCorrectly_when_TimeDurationIsTimePositionOnlyWithSeconds() {
        val timedDurationSeconds = timeDurationBuilder.toTimePosition(0, 0, 2.5)
        val inputTimeOffsetArgument = InputTimeOffsetArgument(timedDurationSeconds)

        val parsedArgument = inputTimeOffsetArgument.parseToString()

        assertThat(parsedArgument).matches("-itsoffset \"00:02.5\"")
    }

    @Test
    fun should_ParseArgumentCorrectly_when_TimeDurationIsTimePositionWithPositiveMinutes() {
        val timedDurationSeconds = timeDurationBuilder.toTimePosition(0, 10, 10.55)
        val inputTimeOffsetArgument = InputTimeOffsetArgument(timedDurationSeconds)

        val parsedArgument = inputTimeOffsetArgument.parseToString()

        assertThat(parsedArgument).matches("-itsoffset \"10:10.55\"")
    }

    @Test
    fun should_ParseArgumentCorrectly_when_TimeDurationIsTimePositionWithNegativeMinutes() {
        val timedDurationSeconds = timeDurationBuilder.toTimePosition(0, -9, 10.55)
        val inputTimeOffsetArgument = InputTimeOffsetArgument(timedDurationSeconds)

        val parsedArgument = inputTimeOffsetArgument.parseToString()

        assertThat(parsedArgument).matches("-itsoffset \"-09:10.55\"")
    }

    @Test
    fun should_ParseArgumentCorrectly_when_TimeDurationIsTimePositionWithPositiveHours() {
        val timedDurationSeconds = timeDurationBuilder.toTimePosition(10, 50, 10.55)
        val inputTimeOffsetArgument = InputTimeOffsetArgument(timedDurationSeconds)

        val parsedArgument = inputTimeOffsetArgument.parseToString()

        assertThat(parsedArgument).matches("-itsoffset \"10:50:10.55\"")
    }

    @Test
    fun should_ParseArgumentCorrectly_when_TimeDurationIsTimePositionWithNegativeHours() {
        val timedDurationSeconds = timeDurationBuilder.toTimePosition(-10, 5, 0.0)
        val inputTimeOffsetArgument = InputTimeOffsetArgument(timedDurationSeconds)

        val parsedArgument = inputTimeOffsetArgument.parseToString()

        assertThat(parsedArgument).matches("-itsoffset \"-10:05:00\"")
    }
}