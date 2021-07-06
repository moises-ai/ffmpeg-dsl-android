package ai.moises.ffmpegdslandroid.ffmpegcommand.initializer

import ai.moises.ffmpegdslandroid.ffmpegcommand.annotation.FFmpegInitializerMarker
import ai.moises.ffmpegdslandroid.ffmpegcommand.filter.panfilter.ChannelType

@FFmpegInitializerMarker
class PanInitializer {
    var channelType: ChannelType = ChannelType.Mono
    var gains: FloatArray = floatArrayOf()
}