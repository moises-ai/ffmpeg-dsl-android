package ai.moises.ffmpegdslandroid.ffmpegcommand.filter.panfilter

import ai.moises.ffmpegdslandroid.ffmpegcommand.assertion.GainAssertion

class MonoPanFilter(gains: FloatArray) : PanFilter(ChannelType.Mono) {
    init {
        GainAssertion.assert(gains)
        setupChannels(gains)
    }

    private fun setupChannels(gains: FloatArray) {
        val channelsWithGain = gains.mapIndexed { index, value ->
            "$value*c$index"
        }
        val channels = channelsWithGain.joinToString("+")
        val channelsConfig = "c0<$channels"

        addChannelConfig(channelsConfig)
    }
}