package ai.moises.ffmpegdslandroid.ffmpegcommand.argument

import ai.moises.ffmpegdslandroid.ffmpegcommand.timeduration.TimeDuration

class SeekStartArgument(override val timeDuration: TimeDuration) : TimeDurationArgument("-ss") {}