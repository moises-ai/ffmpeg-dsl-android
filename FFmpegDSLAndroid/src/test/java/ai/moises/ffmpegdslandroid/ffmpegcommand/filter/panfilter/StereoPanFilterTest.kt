package ai.moises.ffmpegdslandroid.ffmpegcommand.filter.panfilter

import com.google.common.truth.Truth.assertThat
import ai.moises.ffmpegdslandroid.ffmpegcommand.exception.InvalidGainListSize
import org.junit.Test

/**
 * Created by Vinícius Veríssimo on 06/07/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class StereoPanFilterTest {

    @Test
    fun should_CorrectlyParseStereoPanToString_when_GainHasASingleItem() {
        val monoPanFilter = StereoPanFilter(floatArrayOf(1f))

        val parsedString = monoPanFilter.parseToString()

        assertThat(parsedString).isEqualTo("pan=stereo|c0<1.0*c0")
    }

    @Test
    fun should_CorrectlyParseStereoPanToString_when_GainHasMultipleItems() {
        val monoPanFilter = StereoPanFilter(floatArrayOf(1f, 2f))

        val parsedString = monoPanFilter.parseToString()

        assertThat(parsedString).isEqualTo("pan=stereo|c0<1.0*c0|c1<2.0*c1")
    }

    @Test(expected = InvalidGainListSize::class)
    fun should_Fail_when_GainListIsEmpty() {
        StereoPanFilter(floatArrayOf())
    }
}