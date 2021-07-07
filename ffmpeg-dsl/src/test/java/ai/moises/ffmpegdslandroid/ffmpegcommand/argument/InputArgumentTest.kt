package ai.moises.ffmpegdslandroid.ffmpegcommand.argument

import com.google.common.truth.Truth.assertThat
import ai.moises.ffmpegdslandroid.ffmpegcommand.exception.PathIsBlankException
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

    @Test
    fun should_MatchesTheInputPattern_when_ParseTheContentToString() {
        val inputArgument = InputArgument("a")

        val parsedArgument = inputArgument.parseToString()

        assertThat(parsedArgument).matches("-i \"a\"")
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