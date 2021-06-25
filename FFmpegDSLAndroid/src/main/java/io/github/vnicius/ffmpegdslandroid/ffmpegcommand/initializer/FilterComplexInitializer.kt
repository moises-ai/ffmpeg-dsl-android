package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.initializer

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.annotation.FFmpegInitializerMarker
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument.FilterComplexArgument
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.FilterGroup
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.mixfilter.AudioMixFilter

@FFmpegInitializerMarker
class FilterComplexInitializer(private val filterComplexArgument: FilterComplexArgument) {

    fun filterGroup(
        inputStreamSpecifier: String? = null,
        outputStreamSpecifier: String? = null,
        initializer: FilterGroupInitializer.() -> Unit
    ): FilterGroup {
        val filterGroup = FilterGroup(inputStreamSpecifier, outputStreamSpecifier)

        FilterGroupInitializer(filterGroup).apply(initializer)

        filterComplexArgument.addFilterGroup(filterGroup)

        return filterGroup
    }

    fun amix(
        inputsStreamsSpecifiers: List<String>? = null,
        outputStreamSpecifier: String? = null,
        initializer: AudioMixInitializer.() -> Unit
    ): AudioMixFilter {
        val audioMixFilter = AudioMixFilter(inputsStreamsSpecifiers, outputStreamSpecifier)

        AudioMixInitializer(audioMixFilter).apply(initializer)

        filterComplexArgument.addFilter(audioMixFilter)

        return audioMixFilter
    }
}