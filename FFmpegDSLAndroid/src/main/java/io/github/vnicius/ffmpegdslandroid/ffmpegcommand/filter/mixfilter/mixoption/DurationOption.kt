package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.mixfilter.mixoption

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.timeduration.Duration

class DurationOption(duration: Duration): MixOption() {
    override val key: String = "duration"
    override val value: String = duration.value
}