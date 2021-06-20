package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument

import com.google.common.truth.Truth.assertThat
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.exception.PathIsBlankException
import io.github.vnicius.ffmpegdslandroid.util.ArgumentPatternCreator
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by Vinícius Veríssimo on 19/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
@RunWith(JUnit4::class)
class InputArgumentTest {
    private val inputRegex = ArgumentPatternCreator.create("-i", "\".+\"")

    @Test
    fun should_MatchesTheInputPattern_when_ParseTheContentToString() {
        val inputArgument = InputArgument("a")
        val parsedArgument = inputArgument.parseToString()

        assertThat(parsedArgument).matches(inputRegex)
    }

    @Test(expected = PathIsBlankException::class)
    fun should_Fail_when_PathIsEmpty() {
        InputArgument("")
    }

    @Test(expected = PathIsBlankException::class)
    fun should_Fail_when_PathIsBlank() {
        InputArgument("     ")
    }
}