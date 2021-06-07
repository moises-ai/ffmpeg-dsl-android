package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.panfilter

class MonoPanFilter(gains: FloatArray) : PanFilter(ChannelType.Mono, gains) {
    init {
        setupChannels(gains)
    }

    private fun setupChannels(gains: FloatArray) {
        val channelsWithGain = gains.mapIndexed { index, value ->
            "c$index*$value"
        }
        val channels = channelsWithGain.joinToString("+")
        val channelsConfig = "c0<$channels"

        addChannelConfig(channelsConfig)
    }
}