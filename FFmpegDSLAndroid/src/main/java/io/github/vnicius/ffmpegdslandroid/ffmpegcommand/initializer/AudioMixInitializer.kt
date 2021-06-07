package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.initializer

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.DropoutTransitionFilter
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.Duration
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.DurationFilter
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.InputsFilter
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.mixfilter.AudioMixFilter

class AudioMixInitializer {
    val audioMixFilter = AudioMixFilter()
    var inputs: Int? = null
        set(value) {
            field = value
            value?.let(::addInputsFilter)
        }
    var duration: Duration? = null
        set(value) {
            field = value
            value?.let(::addDurationFilter)
        }
    var dropoutTransition: Int? = null
        set(value) {
            field = value
            value?.let(::addDropoutTransitionFilter)
        }

    private fun addInputsFilter(inputsSize: Int) {
        audioMixFilter.addFilter(InputsFilter(inputsSize))
    }

    private fun addDurationFilter(duration: Duration) {
        audioMixFilter.addFilter(DurationFilter(duration))
    }

    private fun addDropoutTransitionFilter(dropoutTransition: Int) {
        audioMixFilter.addFilter(DropoutTransitionFilter(dropoutTransition))
    }
}