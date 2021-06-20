package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.assertion


/**
 * Created by Vinícius Veríssimo on 19/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
interface Assertion<T> {
    fun assert(value: T)
}