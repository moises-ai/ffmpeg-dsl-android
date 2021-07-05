package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.mixfilter

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.streamspecifier.StreamSpecifier

class AudioMixFilter(
    inputsStreamsSpecifiers: List<StreamSpecifier>? = null,
    outputStreamSpecifier: StreamSpecifier? = null
) : MixFilter("amix", inputsStreamsSpecifiers, outputStreamSpecifier) {
}