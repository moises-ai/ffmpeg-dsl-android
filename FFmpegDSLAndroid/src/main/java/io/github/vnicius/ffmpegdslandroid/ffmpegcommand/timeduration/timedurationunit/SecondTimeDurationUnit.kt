package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.timeduration.timedurationunit

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.extension.compress


/**
 * Created by Vinícius Veríssimo on 28/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class SecondTimeDurationUnit: TimeDurationUnit {
    override fun format(value: Number): String {
        return value.compress().toString()
    }
}