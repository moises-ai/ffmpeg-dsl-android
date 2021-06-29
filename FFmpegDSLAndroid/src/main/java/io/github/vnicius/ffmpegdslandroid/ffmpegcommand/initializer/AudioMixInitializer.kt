package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.initializer

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.annotation.FFmpegInitializerMarker
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.Filter
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.mixfilter.AudioMixFilter
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.mixfilter.mixoption.DropoutTransitionOption
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.timeduration.Duration
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.mixfilter.mixoption.DurationOption
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.mixfilter.mixoption.InputsOption

@FFmpegInitializerMarker
class AudioMixInitializer(private val audioMixFilter: AudioMixFilter) : BaseFiltersInitializer() {
    var inputs: Int? = null
        set(value) {
            field = value
            value?.let(::addInputsOption)
        }
    var duration: Duration? = null
        set(value) {
            field = value
            value?.let(::addDurationOption)
        }
    var dropoutTransition: Int? = null
        set(value) {
            field = value
            value?.let(::addDropoutTransitionOption)
        }

    private fun addInputsOption(inputsSize: Int) {
        audioMixFilter.addOption(InputsOption(inputsSize))
    }

    private fun addDurationOption(duration: Duration) {
        audioMixFilter.addOption(DurationOption(duration))
    }

    private fun addDropoutTransitionOption(dropoutTransition: Int) {
        audioMixFilter.addOption(DropoutTransitionOption(dropoutTransition))
    }

    override fun addFilter(filter: Filter) {
        audioMixFilter.addFilter(filter)
    }
}