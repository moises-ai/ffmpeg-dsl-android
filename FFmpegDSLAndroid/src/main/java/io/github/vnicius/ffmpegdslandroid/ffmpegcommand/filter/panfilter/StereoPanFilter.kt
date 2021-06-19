package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.panfilter

class StereoPanFilter(gains: FloatArray) : PanFilter(ChannelType.Stereo) {
    init {
        setupChannelsGain(gains)
    }

    private fun setupChannelsGain(gains: FloatArray) {
        val channelsConfigs = gains.mapIndexed { index, value ->
            "c$index<$value*c$index"
        }

        channelsConfigs.forEach(::addChannelConfig)
    }
}