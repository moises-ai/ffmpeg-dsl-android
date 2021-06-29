package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument

import com.google.common.truth.Truth.assertThat
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.exception.StreamSpecifierIsBlankException
import org.junit.Test

/**
 * Created by Vinícius Veríssimo on 29/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */

class MapArgumentTest {

    @Test(expected = StreamSpecifierIsBlankException::class)
    fun should_Fail_when_StreamSpecifierIsBlank() {
        MapArgument("")
    }

    @Test
    fun should_ParseArgumentCorrectly_when_StreamSpecifierIsNotBlank() {
        val mapArgument = MapArgument("a")

        val parsedArgument = mapArgument.parseToString()

        assertThat(parsedArgument).matches("-map \"a\"")
    }
}