package ai.moises.ffmpegdslandroid.ffmpegcommand.initializer

import ai.moises.ffmpegdslandroid.ffmpegcommand.timeduration.TimeDuration
import ai.moises.ffmpegdslandroid.ffmpegcommand.timeduration.TimeDurationBuilder


/**
 * Created by Vinícius Veríssimo on 28/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */

fun seconds(second: Double): TimeDuration = TimeDurationBuilder().toSecond(second)

fun milliseconds(millisecond: Long): TimeDuration = TimeDurationBuilder().toMillisecond(millisecond)

fun nanoseconds(nanosecond: Long): TimeDuration = TimeDurationBuilder().toNanosecond(nanosecond)

fun hours(hour: Int): TimeDuration =
    TimeDurationBuilder().toTimePosition(hour, 0, 0.0)

fun minutes(minute: Int): TimeDuration =
    TimeDurationBuilder().toTimePosition(0, minute, 0.0)

fun timePosition(second: Double): TimeDuration =
    TimeDurationBuilder().toTimePosition(second)

fun timePosition(minute: Int, second: Double): TimeDuration =
    TimeDurationBuilder().toTimePosition(minute, second)

fun timePosition(hour: Int, minute: Int, second: Double): TimeDuration =
    TimeDurationBuilder().toTimePosition(hour, minute, second)