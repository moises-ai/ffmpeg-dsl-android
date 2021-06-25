package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.mixfilter

class AudioMixFilter(
    inputsStreamsSpecifiers: List<String>? = null,
    outputStreamSpecifier: String? = null
) : MixFilter("amix", inputsStreamsSpecifiers, outputStreamSpecifier) {
}