package ai.moises.ffmpegdslandroid.ffmpegcommand.filter

import com.google.common.truth.Truth.assertThat
import ai.moises.ffmpegdslandroid.ffmpegcommand.streamspecifier.StreamSpecifier
import ai.moises.ffmpegdslandroid.ffmpegcommand.streamspecifier.StreamType
import org.junit.Test

/**
 * Created by Vinícius Veríssimo on 05/07/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class FilterTagGeneratorTest {
    @Test
    fun should_GenerateAStringInTagFormat_when_TheEnterIsAStreamSpecifier() {
        val filterTagGenerator = FilterTagGenerator()

        val tagString = filterTagGenerator.generateTagFromStreamSpecifier(StreamSpecifier(1, StreamType.Audio))

        assertThat(tagString).isEqualTo("[1:a]")
    }
}