package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter

class AudioTempoFilter(tempo: Double): Filter() {
    override val key: String = "atempo"
    override val value: String = tempo.toString()
}