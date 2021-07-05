package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.assertion.VolumeAssertion

class VolumeFilter(volume: Number): Filter() {
    override val key: String = "volume"
    override val value: String = volume.toString()

    init {
        VolumeAssertion.assert(volume)
    }
}