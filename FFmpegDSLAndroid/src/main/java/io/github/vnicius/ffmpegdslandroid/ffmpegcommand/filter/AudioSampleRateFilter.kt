package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter

open class AudioSampleRateFilter(sampleRate: Float): SampleRateFilter(sampleRate) {
    override val key: String = "asetrate"
}