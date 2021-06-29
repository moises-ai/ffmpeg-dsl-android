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

    @Test
    fun should_HaveBasicKey_when_StreamSpecifierIsNull() {
        val codecArgument = CodecArgument("libcodec", null)
        val codecKey = codecArgument.key

        assertThat(codecKey).matches("-c")
    }

    @Test
    fun should_HaveBasicKey_when_StreamSpecifierIsBlank() {
        val codecArgument = CodecArgument("libcodec", "")
        val codecKey = codecArgument.key

        assertThat(codecKey).matches("-c")
    }

    @Test
    fun should_ContainsStreamSpecifierAtTheEndOfTheKey_when_StreamSpecifierIsNotBlank() {
        val codecArgument = CodecArgument("libcodec", "a:1")

        val codecKey = codecArgument.key

        assertThat(codecKey).endsWith("-c:a:1")
    }

    @Test(expected = CodecNotSupportedException::class)
    fun should_FailToConstruct_when_CodecIsBlank() {
        CodecArgument("")
    }

    @Test
    fun should_ParseArgumentCorrectly_when_CodecAndStreamSpecifierAreNotBlank() {
        val codecArgument = CodecArgument("libcodec", "a")

        val codecArgumentParsed = codecArgument.parseToString()

        assertThat(codecArgumentParsed).matches("-c:a \"libcodec\"")
    }
}