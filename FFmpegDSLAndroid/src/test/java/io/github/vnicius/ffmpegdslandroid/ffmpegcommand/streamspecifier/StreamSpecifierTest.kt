package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.streamspecifier

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
 * Created by Vinícius Veríssimo on 05/07/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class StreamSpecifierTest {

    @Test
    fun should_CorrectlyPartStreamSpecifierToString_when_ConstructWithIndexAndStreamType() {
        val streamSpecifier = StreamSpecifier(0, StreamType.Audio)

        val parsedStreamSpecifier = streamSpecifier.parseToString()

        assertThat(parsedStreamSpecifier).isEqualTo("0:a")
    }

    @Test
    fun should_CorrectlyPartStreamSpecifierToString_when_ConstructWithIndexStreamTypeAndAdditionalStreamSpecifier() {
        val streamSpecifier = StreamSpecifier(0, StreamType.Video, 1)

        val parsedStreamSpecifier = streamSpecifier.parseToString()

        assertThat(parsedStreamSpecifier).isEqualTo("0:v:1")
    }

    @Test
    fun should_CorrectlyPartStreamSpecifierToString_when_ConstructOnlyWithStreamType() {
        val streamSpecifier = StreamSpecifier(StreamType.Subtitle)

        val parsedStreamSpecifier = streamSpecifier.parseToString()

        assertThat(parsedStreamSpecifier).isEqualTo("s")
    }

    @Test
    fun should_CorrectlyPartStreamSpecifierToString_when_ConstructWithStreamTypeAndAdditionalStreamSpecifier() {
        val streamSpecifier = StreamSpecifier(StreamType.Audio, 0)

        val parsedStreamSpecifier = streamSpecifier.parseToString()

        assertThat(parsedStreamSpecifier).isEqualTo("a:0")
    }

    @Test
    fun should_CorrectlyPartStreamSpecifierToString_when_ConstructWithStreamTypeAndCustomAdditionalStreamSpecifier() {
        val streamSpecifier = StreamSpecifier(StreamType.Audio, "1")

        val parsedStreamSpecifier = streamSpecifier.parseToString()

        assertThat(parsedStreamSpecifier).isEqualTo("a1")
    }
}