package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter

class AudioTempoFilter(tempo: Float): Filter() {
    override val key: String = "atempo"
    override val value: String = tempo.toString()
}