package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.timeduration.timedurationunit


/**
 * Created by Vinícius Veríssimo on 28/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
interface TimeDurationUnit {
    fun format(value: Number): String
}