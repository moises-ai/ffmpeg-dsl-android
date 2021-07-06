package ai.moises.ffmpegdslandroid.ffmpegcommand.filter

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
 * Created by Vinícius Veríssimo on 01/07/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class AudioResampleFilterTest {
    @Test
    fun should_CorrectlyParseTheArgument_when_DefinedASampleRateIsAnIntegerValue() {
        val audioResampleFilter = AudioResampleFilter(44100)

        val parsedFilter = audioResampleFilter.parseToString()

        assertThat(parsedFilter).isEqualTo("aresample=44100")
    }

    @Test
    fun should_CorrectlyParseTheArgument_when_DefinedASampleRateIsAnFloatValue() {
        val audioResampleFilter = AudioResampleFilter(100f)

        val parsedFilter = audioResampleFilter.parseToString()

        assertThat(parsedFilter).isEqualTo("aresample=100.0")
    }

    @Test
    fun should_CorrectlyParseTheArgument_when_DefinedASampleRateIsAnDoubleValue() {
        val audioResampleFilter = AudioResampleFilter(200.0)

        val parsedFilter = audioResampleFilter.parseToString()

        assertThat(parsedFilter).isEqualTo("aresample=200.0")
    }
}