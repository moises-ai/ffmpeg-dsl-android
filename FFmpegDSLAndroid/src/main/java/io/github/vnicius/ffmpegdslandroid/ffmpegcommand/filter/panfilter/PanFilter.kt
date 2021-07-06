package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.panfilter

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.Filter

abstract class PanFilter(private val channelType: ChannelType) : Filter() {
    override val key: String = "pan"
    override val value: String
        get() = getChannelsAsString()

    private val channelsConfigs: MutableList<String> = mutableListOf()

    private fun getChannelsAsString(): String {
        val separator = "|"
        val channels = channelsConfigs.joinToString(separator)

        return "${channelType.value}$separator$channels"
    }

    fun addChannelConfig(channelConfig: String) {
        channelsConfigs.add(channelConfig)
    }
}