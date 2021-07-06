package ai.moises.ffmpegdslandroid.ffmpegcommand.initializer

import ai.moises.ffmpegdslandroid.ffmpegcommand.annotation.FFmpegInitializerMarker
import ai.moises.ffmpegdslandroid.ffmpegcommand.argument.FilterComplexArgument
import ai.moises.ffmpegdslandroid.ffmpegcommand.filter.FilterGroup
import ai.moises.ffmpegdslandroid.ffmpegcommand.filter.mixfilter.AudioMixFilter
import ai.moises.ffmpegdslandroid.ffmpegcommand.streamspecifier.StreamSpecifier

@FFmpegInitializerMarker
class FilterComplexInitializer(private val filterComplexArgument: FilterComplexArgument) {

    fun filterGroup(
        inputStreamSpecifier: StreamSpecifier? = null,
        outputStreamSpecifier: StreamSpecifier? = null,
        initializer: FilterGroupInitializer.() -> Unit
    ): FilterGroup {
        val filterGroup = FilterGroup(inputStreamSpecifier, outputStreamSpecifier)

        FilterGroupInitializer(filterGroup).apply(initializer)

        filterComplexArgument.addFilterGroup(filterGroup)

        return filterGroup
    }

    fun amix(
        inputsStreamsSpecifiers: List<StreamSpecifier>? = null,
        outputStreamSpecifier: StreamSpecifier? = null,
        initializer: AudioMixInitializer.() -> Unit
    ): AudioMixFilter {
        val audioMixFilter = AudioMixFilter(inputsStreamsSpecifiers, outputStreamSpecifier)

        AudioMixInitializer(audioMixFilter).apply(initializer)

        filterComplexArgument.addFilter(audioMixFilter)

        return audioMixFilter
    }
}