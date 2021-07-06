package ai.moises.ffmpegdslandroid.ffmpegcommand.timeduration

import ai.moises.ffmpegdslandroid.ffmpegcommand.assertion.TimeAssertion
import ai.moises.ffmpegdslandroid.ffmpegcommand.exception.InvalidTimeException
import ai.moises.ffmpegdslandroid.ffmpegcommand.extension.compress
import ai.moises.ffmpegdslandroid.ffmpegcommand.extension.formatToTime
import java.util.concurrent.TimeUnit
import kotlin.math.abs


/**
 * Created by Vinícius Veríssimo on 28/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class TimePosition private constructor(): TimeDuration {

    private var timeDurationString: String = ""

    constructor(hour: Int, minute: Int, second: Double) : this() {
        timeDurationString = parseTime(hour, minute, second)
    }

    constructor(minute: Int, second: Double): this() {
        timeDurationString = parseTime(0, minute, second)
    }

    constructor(second: Double): this() {
        timeDurationString = parseTime(0, 0, second)
    }

    private fun parseTime(hour: Int, minute: Int, second: Double): String {
        val timeStringBuilder = StringBuilder()

        appendHour(timeStringBuilder, hour)
        assertMinute(hour, minute)
        appendMinute(timeStringBuilder, minute)
        assertSecond(hour, minute, second)
        appendSecond(timeStringBuilder, second)

        return timeStringBuilder.toString()
    }

    private fun assertMinute(hour: Int, minute: Int) {
        if (hour != 0 && minute < 0) {
            throw InvalidTimeException(TimeUnit.MINUTES, minute)
        }

        TimeAssertion.MinutesAssertion.assert(minute)
    }

    private fun assertSecond(hour: Int, minute: Int, second: Double) {
        if ((hour != 0 || minute != 0) && second < 0) {
            throw InvalidTimeException(TimeUnit.SECONDS, second)
        }

        TimeAssertion.SecondsAssertion.assert(second)
    }

    private fun appendHour(stringBuilder: StringBuilder, hour: Int) {
        if (hour != 0) {
            stringBuilder.append(hour.formatToTime()).append(":")
        }
    }

    private fun appendMinute(stringBuilder: StringBuilder, minute: Int) {
        stringBuilder.append(minute.formatToTime()).append(":")
    }

    private fun appendSecond(stringBuilder: StringBuilder, second: Double) {
        val absSecond = abs(second)

        if (second < 0) {
            stringBuilder.insert(0, "-")
        }

        stringBuilder.append(absSecond.compress().formatToTime())
    }

    override fun format(): String = timeDurationString
}