package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.timeduration.TimeDuration


abstract class TimeDurationArgument(override val key: String) : Argument() {
    abstract val timeDuration: TimeDuration
    override val value: String
        get() = timeDuration.format()
}