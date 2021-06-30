package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.timeduration

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.timeduration.timedurationunit.MillisecondTimeDurationUnit
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.timeduration.timedurationunit.NanosecondTimeDurationUnit
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.timeduration.timedurationunit.SecondTimeDurationUnit


/**
 * Created by Vinícius Veríssimo on 28/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class TimeDurationBuilder {
    fun toSecond(second: Double): TimeDuration = SimpleTimeDuration(second, SecondTimeDurationUnit())

    fun toMillisecond(millisecond: Long): TimeDuration =
        SimpleTimeDuration(millisecond, MillisecondTimeDurationUnit())

    fun toNanosecond(nanosecond: Long): TimeDuration =
        SimpleTimeDuration(nanosecond, NanosecondTimeDurationUnit())

    fun toTimePosition(hour: Int, minute: Int, second: Double): TimeDuration =
        TimePosition(hour, minute, second)
}