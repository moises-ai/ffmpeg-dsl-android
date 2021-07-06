package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument

import com.google.common.truth.Truth.assertThat
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.exception.CodecNotSupportedException
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.streamspecifier.StreamSpecifier
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.streamspecifier.StreamType
import org.junit.Test

/**
 * Created by Vinícius Veríssimo on 21/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class CodecArgumentTest {

    @Test
    fun should_HaveBasicKey_when_StreamSpecifierIsNull() {
        val codecArgument = CodecArgument("libcodec")
        val codecKey = codecArgument.key

        assertThat(codecKey).isEqualTo("-c")
    }

    @Test
    fun should_ContainsStreamSpecifierAtTheEndOfTheKey_when_StreamSpecifierIsNotNull() {
        val codecArgument = CodecArgument("libcodec", StreamSpecifier(StreamType.Audio, 1))

        val codecKey = codecArgument.key

        assertThat(codecKey).isEqualTo("-c:a:1")
    }

    @Test(expected = CodecNotSupportedException::class)
    fun should_FailToConstruct_when_CodecIsBlank() {
        CodecArgument("")
    }

    @Test
    fun should_ParseArgumentCorrectly_when_CodecAndStreamSpecifierAreNotBlank() {
        val codecArgument = CodecArgument("libcodec", StreamSpecifier(StreamType.Audio))

        val codecArgumentParsed = codecArgument.parseToString()

        assertThat(codecArgumentParsed).isEqualTo("-c:a \"libcodec\"")
    }
}