package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter

open class AudioSampleRateFilter(private val sampleRate: Float): Filter() {
    override val key: String = "asetrate"
    override val value: String
        get() = "$sampleRate"
}