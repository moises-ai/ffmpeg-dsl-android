package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.initializer

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.annotation.FFmpegInitializerMarker
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.panfilter.PanFilter
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.panfilter.PanFilterFactory
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.*

@FFmpegInitializerMarker
abstract class BaseFiltersInitializer {
    var audioSampleRate: Float? = null
        set(value) {
            field = value
            value?.let(::addAudioSampleRateFilter)
        }
    var audioResampleRate: Float? = null
        set(value) {
            field = value
            value?.let(::addAudioResampleRateFilter)
        }
    var audioTempo: Float? = null
        set(value) {
            field = value
            value?.let(::addAudioTempoFilter)
        }
    var volume: Number? = null
        set(value) {
            field = value
            value?.let(::addVolumeFilter)
        }


    private fun addAudioSampleRateFilter(sampleRate: Float) {
        addFilter(AudioSampleRateFilter(sampleRate))
    }

    private fun addAudioResampleRateFilter(resampleRate: Float) {
        addFilter(AudioResampleFilter(resampleRate))
    }

    private fun addAudioTempoFilter(tempo: Float) {
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

    abstract fun addFilter(filter: Filter)
}