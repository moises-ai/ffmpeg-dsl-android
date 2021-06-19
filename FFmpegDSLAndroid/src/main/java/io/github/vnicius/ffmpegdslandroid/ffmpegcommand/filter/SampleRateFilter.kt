package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter


/**
 * Created by Vinícius Veríssimo on 19/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
abstract class SampleRateFilter(sampleRate: Float): Filter() {
    override val value: String = sampleRate.toString()
}