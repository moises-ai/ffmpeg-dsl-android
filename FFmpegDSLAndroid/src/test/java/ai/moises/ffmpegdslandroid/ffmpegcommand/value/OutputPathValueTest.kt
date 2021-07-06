package ai.moises.ffmpegdslandroid.ffmpegcommand.value

import com.google.common.truth.Truth.assertThat
import ai.moises.ffmpegdslandroid.ffmpegcommand.exception.ValueIsBlankException
import org.junit.Test

/**
 * Created by Vinícius Veríssimo on 01/07/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class OutputPathValueTest {

    @Test
    fun should_CorrectlyParseTheValue_when_PathIsNotEmpty() {
        val outputPathValue = OutputPathValue("abc")

        val parsedPath = outputPathValue.parseToString()

        assertThat(parsedPath).isEqualTo("\"abc\"")
    }

    @Test(expected = ValueIsBlankException::class)
    fun should_Fails_when_ParsePathWithBlankValue() {
        val outputPathValue = OutputPathValue("")

        outputPathValue.parseToString()
    }
}