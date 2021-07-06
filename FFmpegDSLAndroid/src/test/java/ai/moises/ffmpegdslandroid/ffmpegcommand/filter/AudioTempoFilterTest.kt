package ai.moises.ffmpegdslandroid.ffmpegcommand.filter

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
 * Created by Vinícius Veríssimo on 01/07/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class AudioTempoFilterTest {
    @Test
    fun should_CorrectlyParseTheFilter_when_SetAValue() {
        val audioTempoFilter = AudioTempoFilter(2.0)

        val parsedFilter = audioTempoFilter.parseToString()

        assertThat(parsedFilter).isEqualTo("atempo=2.0")
    }
}