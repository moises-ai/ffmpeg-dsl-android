package io.github.vnicius.ffmpegdslandroid.util


/**
 * Created by Vinícius Veríssimo on 19/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
object ArgumentPatternCreator {
    fun create(key: String, value: String): String =
        "$key $value"
}