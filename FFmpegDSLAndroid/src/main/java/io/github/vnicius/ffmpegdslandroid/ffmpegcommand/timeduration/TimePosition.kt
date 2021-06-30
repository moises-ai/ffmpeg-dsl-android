package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.timeduration

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.assertion.TimeAssertion
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.exception.InvalidTimeException
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.extension.compress
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.extension.formatToTime
import java.util.concurrent.TimeUnit


/**
 * Created by Vinícius Veríssimo on 28/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class TimePosition private constructor(): TimeDuration {

    private var timeDurationString: String = ""

    constructor(hour: Int = 0, minute: Int, second: Double) : this() {
        timeDurationString = parseTime(hour, minute, second)
    }

    private fun parseTime(hour: Int, minute: Int, second: Double): String {
        val timeStringBuilder = StringBuilder()

        appendHour(timeStringBuilder, hour)
        appendMinute(timeStringBuilder, hour, minute)
        appendSecond(timeStringBuilder, second)

        return timeStringBuilder.toString()
    }

    private fun appendHour(stringBuilder: StringBuilder, hour: Int) {
        if (hour != 0) {
            stringBuilder.append(hour.formatToTime()).append(":")
        }
    }

    private fun appendMinute(stringBuilder: StringBuilder, hour: Int, minute: Int) {
        if (hour != 0 && minute < 0) {
            throw InvalidTimeException(TimeUnit.MINUTES, minute)
        }

        TimeAssertion.MinutesAssertion.assert(minute)

        stringBuilder.append(minute.formatToTime()).append(":")
    }

    private fun appendSecond(stringBuilder: StringBuilder, second: Double) {
        TimeAssertion.SecondsAssertion.assert(second)

        stringBuilder.append(second.compress().formatToTime())
    }

    override fun format(): String = timeDurationString
}