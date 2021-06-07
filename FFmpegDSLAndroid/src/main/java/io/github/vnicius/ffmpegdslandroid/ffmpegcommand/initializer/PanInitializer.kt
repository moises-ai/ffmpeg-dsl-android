package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.initializer

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.panfilter.ChannelType

class PanInitializer {
    var channelType: ChannelType = ChannelType.Mono
    var gains: FloatArray = floatArrayOf()
}