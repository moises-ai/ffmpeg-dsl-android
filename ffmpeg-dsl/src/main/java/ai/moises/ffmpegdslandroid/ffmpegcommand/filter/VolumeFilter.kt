package ai.moises.ffmpegdslandroid.ffmpegcommand.filter

import ai.moises.ffmpegdslandroid.ffmpegcommand.assertion.VolumeAssertion

class VolumeFilter(volume: Number): Filter() {
    override val key: String = "volume"
    override val value: String = volume.toString()

    init {
        VolumeAssertion.assert(volume)
    }
}