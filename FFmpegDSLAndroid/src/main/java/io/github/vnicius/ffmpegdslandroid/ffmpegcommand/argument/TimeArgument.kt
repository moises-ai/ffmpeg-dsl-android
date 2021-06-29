package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.timeduration.TimeDuration

class TimeArgument(override val timeDuration: TimeDuration) : TimeDurationArgument("-t") {}