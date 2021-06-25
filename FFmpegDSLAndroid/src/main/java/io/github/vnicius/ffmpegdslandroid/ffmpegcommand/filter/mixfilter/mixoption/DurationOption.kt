package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.mixfilter.mixoption

class DurationOption(duration: Duration): MixOption() {
    override val key: String = "duration"
    override val value: String = duration.value
}