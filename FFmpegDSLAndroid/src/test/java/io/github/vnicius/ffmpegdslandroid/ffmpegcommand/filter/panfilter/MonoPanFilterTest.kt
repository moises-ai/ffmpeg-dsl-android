package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.panfilter

import com.google.common.truth.Truth.assertThat
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.exception.InvalidGainListSize
import org.junit.Test

/**
 * Created by Vinícius Veríssimo on 06/07/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class MonoPanFilterTest {

    @Test
    fun should_CorrectlyParseMonoPanToString_when_GainHasASingleItem() {
        val monoPanFilter = MonoPanFilter(floatArrayOf(1f))

        val parsedString = monoPanFilter.parseToString()

        assertThat(parsedString).isEqualTo("pan=1c|c0<1.0*c0")
    }

    @Test
    fun should_CorrectlyParseMonoPanToString_when_GainHasMultipleItems() {
        val monoPanFilter = MonoPanFilter(floatArrayOf(1f, 2f, .5f))

        val parsedString = monoPanFilter.parseToString()

        assertThat(parsedString).isEqualTo("pan=1c|c0<1.0*c0+2.0*c1+0.5*c2")
    }

    @Test(expected = InvalidGainListSize::class)
    fun should_Fail_when_GainListIsEmpty() {
        MonoPanFilter(floatArrayOf())
    }
}