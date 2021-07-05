package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter

import com.google.common.truth.Truth.assertThat
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.exception.InvalidVolumeException
import org.junit.Test

/**
 * Created by Vinícius Veríssimo on 05/07/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class VolumeFilterTest {

    @Test
    fun should_CorrectlyParseTheVolumeFilterToString_when_TheValueIsAPositiveNumber() {
        val volumeFilter = VolumeFilter(10)

        val parsedString = volumeFilter.toString()

        assertThat(parsedString).isEqualTo("volume=10")
    }

    @Test(expected = InvalidVolumeException::class)
    fun should_Fail_when_ValueIsANegativeNumber() {
        VolumeFilter(-5)
    }
}