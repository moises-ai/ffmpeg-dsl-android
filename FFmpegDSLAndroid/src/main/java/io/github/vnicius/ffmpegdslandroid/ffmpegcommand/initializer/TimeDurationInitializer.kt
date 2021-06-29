package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.initializer

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.timeduration.TimeDuration
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.timeduration.TimeDurationBuilder


/**
 * Created by Vinícius Veríssimo on 28/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */

fun seconds(second: Float): TimeDuration = TimeDurationBuilder().toSecond(second)

fun milliseconds(millisecond: Long): TimeDuration = TimeDurationBuilder().toMillisecond(millisecond)

fun nanoseconds(nanosecond: Long): TimeDuration = TimeDurationBuilder().toNanosecond(nanosecond)

fun hours(hour: Int): TimeDuration =
    TimeDurationBuilder().toTimePosition(hour, 0, 0f)

fun minutes(minute: Int): TimeDuration =
    TimeDurationBuilder().toTimePosition(0, minute, 0f)

fun timePosition(second: Float): TimeDuration =
    TimeDurationBuilder().toTimePosition(0, 0, second)

fun timePosition(minute: Int, second: Float): TimeDuration =
    TimeDurationBuilder().toTimePosition(0, minute, second)

fun timePosition(hour: Int, minute: Int, second: Float): TimeDuration =
    TimeDurationBuilder().toTimePosition(hour, minute, second)