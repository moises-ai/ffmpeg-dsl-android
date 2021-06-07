package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter

class AudioResampleFilter(sampleRate: Float) : AudioSampleRateFilter(sampleRate) {
    override val key: String = "aresample"
}