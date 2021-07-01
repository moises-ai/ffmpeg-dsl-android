package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter

class AudioSampleRateFilter(sampleRate: Number) : Filter() {
    override val key: String = "asetrate"
    override val value: String = sampleRate.toString()
}