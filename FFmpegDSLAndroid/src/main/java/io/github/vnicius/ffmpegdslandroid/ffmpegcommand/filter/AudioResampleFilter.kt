package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter

class AudioResampleFilter(sampleRate: Float) : SampleRateFilter(sampleRate) {
    override val key: String = "aresample"
}