package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.timeduration.TimeDuration

class SeekStartArgument(override val timeDuration: TimeDuration) : TimeDurationArgument("-ss") {}