package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.assertion.CodecAssertion
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.streamspecifier.StreamSpecifier


/**
 * Created by Vinícius Veríssimo on 21/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class CodecArgument(codec: String, private val streamSpecifier: StreamSpecifier? = null): Argument() {
    override val key: String
        get() = generateKey()
    override val value: String = codec

    init {
        CodecAssertion.assert(codec)
    }

    private fun generateKey(): String {
        val specifier = streamSpecifier?.parseToString()?.let {
            ":$it"
        } ?: ""

        return BASE_KEY + specifier
    }

    companion object {
        const val BASE_KEY = "-c"
    }
}