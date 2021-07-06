package ai.moises.ffmpegdslandroid.ffmpegcommand.filter.mixfilter

import ai.moises.ffmpegdslandroid.ffmpegcommand.streamspecifier.StreamSpecifier

class AudioMixFilter(
    inputsStreamsSpecifiers: List<StreamSpecifier>? = null,
    outputStreamSpecifier: StreamSpecifier? = null
) : MixFilter("amix", inputsStreamsSpecifiers, outputStreamSpecifier) {
}