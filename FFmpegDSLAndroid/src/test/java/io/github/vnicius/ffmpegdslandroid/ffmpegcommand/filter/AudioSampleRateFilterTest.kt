package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
 * Created by Vinícius Veríssimo on 01/07/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class AudioSampleRateFilterTest {
    @Test
    fun should_CorrectlyParseTheArgument_when_DefinedASampleRateIsAnIntegerValue() {
        val audioSampleRateFilter = AudioSampleRateFilter(44100)

        val parsedFilter = audioSampleRateFilter.parseToString()

        assertThat(parsedFilter).isEqualTo("asetrate=44100")
    }

    @Test
    fun should_CorrectlyParseTheArgument_when_DefinedASampleRateIsAnFloatValue() {
        val audioSampleRateFilter = AudioSampleRateFilter(100f)

        val parsedFilter = audioSampleRateFilter.parseToString()

        assertThat(parsedFilter).isEqualTo("asetrate=100.0")
    }

    @Test
    fun should_CorrectlyParseTheArgument_when_DefinedASampleRateIsAnDoubleValue() {
        val audioSampleRateFilter = AudioSampleRateFilter(200.0)

        val parsedFilter = audioSampleRateFilter.parseToString()

        assertThat(parsedFilter).isEqualTo("asetrate=200.0")
    }
}