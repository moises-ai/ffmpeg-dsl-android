package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter

class AudioResampleFilter(sampleRate: Number) : Filter() {
    override val key: String = "aresample"
    override val value: String = sampleRate.toString()
}