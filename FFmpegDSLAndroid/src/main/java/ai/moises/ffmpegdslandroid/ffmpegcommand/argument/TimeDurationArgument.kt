package ai.moises.ffmpegdslandroid.ffmpegcommand.argument

import ai.moises.ffmpegdslandroid.ffmpegcommand.timeduration.TimeDuration


abstract class TimeDurationArgument(override val key: String) : Argument() {
    abstract val timeDuration: TimeDuration
    override val value: String
        get() = timeDuration.format()
}