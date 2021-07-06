package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.panfilter

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.assertion.GainAssertion

class StereoPanFilter(gains: FloatArray) : PanFilter(ChannelType.Stereo) {
    init {
        GainAssertion.assert(gains)
        setupChannelsGain(gains)
    }

    private fun setupChannelsGain(gains: FloatArray) {
        val channelsConfigs = gains.mapIndexed { index, value ->
            "c$index<$value*c$index"
        }

        channelsConfigs.forEach(::addChannelConfig)
    }
}