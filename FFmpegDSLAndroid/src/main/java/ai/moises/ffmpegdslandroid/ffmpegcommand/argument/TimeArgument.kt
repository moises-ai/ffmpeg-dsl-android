package ai.moises.ffmpegdslandroid.ffmpegcommand.argument

import ai.moises.ffmpegdslandroid.ffmpegcommand.timeduration.TimeDuration

class TimeArgument(override val timeDuration: TimeDuration) : TimeDurationArgument("-t") {}