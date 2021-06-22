package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument

import com.google.common.truth.Truth.assertThat
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.exception.CodecNotSupportedException
import org.junit.Test

/**
 * Created by Vinícius Veríssimo on 21/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class CodecArgumentTest {
    private val codecKeyPattern = "^(-c|(-codec)):?[^ ]*".toPattern()
    private val codecArgumentPattern = "^(-c|(-codec)):?[^ ]* [^ ]+".toPattern()

    @Test
    fun should_HaveBasicKey_when_StreamSpecifierIsNull() {
        val codecArgument = CodecArgument("libcodec", null)
        val codecKey = codecArgument.key

        assertThat(codecKey).matches(codecKeyPattern)
    }

    @Test
    fun should_HaveBasicKey_when_StreamSpecifierIsBlank() {
        val codecArgument = CodecArgument("libcodec", "")
        val codecKey = codecArgument.key

        assertThat(codecKey).matches(codecKeyPattern)
    }

    @Test
    fun should_ContainsStreamSpecifierAtTheEndOfTheKey_when_StreamSpecifierIsNotBlank() {
        val streamSpecifier = "a:1"
        val codecArgument = CodecArgument("libcodec", streamSpecifier)
        val codecKey = codecArgument.key

        assertThat(codecKey).matches(codecKeyPattern)
        assertThat(codecKey).endsWith(streamSpecifier)
    }

    @Test(expected = CodecNotSupportedException::class)
    fun should_FailToConstruct_when_CodecIsBlank() {
        CodecArgument("")
    }

    @Test
    fun should_MatchesCodecArgumentPattern_when_CodecAndStreamSpecifierAreNotBlank() {
        val codecArgument = CodecArgument("libcodec", "a")
        val codecArgumentParsed = codecArgument.parseToString()

        assertThat(codecArgumentParsed).matches(codecArgumentPattern)
    }
}