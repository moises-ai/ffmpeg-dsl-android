package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.initializer

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.annotation.FFmpegInitializerMarker
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.*
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.panfilter.PanFilter
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.panfilter.PanFilterFactory

@FFmpegInitializerMarker
abstract class BaseFiltersInitializer {
    var audioSampleRate: Number? = null
        set(value) {
            field = value
            value?.let(::addAudioSampleRateFilter)
        }
    var audioResampleRate: Number? = null
        set(value) {
            field = value
            value?.let(::addAudioResampleRateFilter)
        }
    var audioTempo: Double? = null
        set(value) {
            field = value
            value?.let(::addAudioTempoFilter)
        }
    var volume: Number? = null
        set(value) {
            field = value
            value?.let(::addVolumeFilter)
        }


    private fun addAudioSampleRateFilter(sampleRate: Number) {
        addFilter(AudioSampleRateFilter(sampleRate))
    }

    private fun addAudioResampleRateFilter(resampleRate: Number) {
        addFilter(AudioResampleFilter(resampleRate))
    }

    private fun addAudioTempoFilter(tempo: Double) {
        addFilter(AudioTempoFilter(tempo))
    }

    private fun addVolumeFilter(volume: Number) {
        addFilter(VolumeFilter(volume))
    }

    fun pan(initializer: PanInitializer.() -> Unit): PanFilter {
        val panInitializer = PanInitializer().apply(initializer)
        val panFilter = PanFilterFactory.create(panInitializer.channelType, panInitializer.gains)

        addFilter(panFilter)

        return panFilter
    }

    protected abstract fun addFilter(filter: Filter)
}