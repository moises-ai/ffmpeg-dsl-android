package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.initializer

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.annotation.FFmpegInitializerMarker
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument.FilterComplexArgument
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.Filter
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.FilterGroup
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.mixfilter.AudioMixFilter

@FFmpegInitializerMarker
class FilterComplexInitializer {
    val filterComplexArgument: FilterComplexArgument = FilterComplexArgument()

    fun filterGroup(
        inputTag: String? = null,
        outputTag: String? = null,
        initializer: FilterGroupInitializer.() -> Unit
    ): FilterGroup {
        val filterGroupInitializer = FilterGroupInitializer(inputTag, outputTag).apply(initializer)
        val filterGroup = filterGroupInitializer.filterGroup

        filterComplexArgument.addFilterGroup(filterGroup)

        return filterGroup
    }

    fun filters(initializer: FiltersInitializer.() -> Unit): List<Filter> {
        val filterInitializer = FiltersInitializer().apply(initializer)
        val filters = filterInitializer.filters

        filters.forEach {
            filterComplexArgument.addFilter(it)
        }

        return filters
    }

    fun amix(initializer: AudioMixInitializer.() -> Unit): AudioMixFilter {
        val audioMixInitializer = AudioMixInitializer().apply(initializer)
        val audioMixFilter = audioMixInitializer.audioMixFilter

        filterComplexArgument.addFilter(audioMixFilter)

        return audioMixFilter
    }
}