package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter

class VolumeFilter(volume: Number): Filter() {
    override val key: String = "volume"
    override val value: String = volume.toString()
}