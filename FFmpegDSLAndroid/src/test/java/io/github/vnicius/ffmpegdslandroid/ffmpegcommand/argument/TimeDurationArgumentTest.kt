package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument

import com.google.common.truth.Truth.assertThat
import io.github.vnicius.ffmpegdslandroid.util.ArgumentPatternCreator
import org.junit.Test

/**
 * Created by Vinícius Veríssimo on 19/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class TimeDurationArgumentTest {

    @Test
    fun should_ReturnSameKey_when_ParseTheContentToString() {
        val key = "-x"
        val timePositionArgument = TimeDurationArgument(key)
        timePositionArgument.setPosition(0)

        val parsedArgument = timePositionArgument.parseToString()

        assertThat(parsedArgument).startsWith(key)
    }

    @Test
    fun should_MatchesTimePositionInSeconds_when_ValueIsAInt() {
        val key = "-x"
        val position = 2
        val timePositionArgumentPattern = ArgumentPatternCreator.create(key, position.toString())
        val timePositionArgument = TimeDurationArgument(key)

        timePositionArgument.setPosition(position)

        val parsedArgument = timePositionArgument.parseToString()

        assertThat(parsedArgument).matches(timePositionArgumentPattern)
    }

    @Test
    fun should_MatchesTimePositionInSeconds_when_ValueIsAFloat() {
        val key = "-x"
        val position = 3f
        val timePositionArgumentPattern = ArgumentPatternCreator.create(key, position.toString())
        val timePositionArgument = TimeDurationArgument(key)

        timePositionArgument.setPosition(position)

        val parsedArgument = timePositionArgument.parseToString()

        assertThat(parsedArgument).matches(timePositionArgumentPattern)
    }

    @Test
    fun should_MatchesTimePositionInMilliseconds_when_ValueIsALong() {
        val key = "-x"
        val position = 300L
        val timePositionArgumentPattern = ArgumentPatternCreator.create(key, "${position}ms")
        val timePositionArgument = TimeDurationArgument(key)

        timePositionArgument.setPosition(position)

        val parsedArgument = timePositionArgument.parseToString()

        assertThat(parsedArgument).matches(timePositionArgumentPattern)
    }
}