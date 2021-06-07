package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter

class DurationFilter(duration: Duration): Filter() {
    override val key: String = "duration"
    override val value: String = duration.value
}