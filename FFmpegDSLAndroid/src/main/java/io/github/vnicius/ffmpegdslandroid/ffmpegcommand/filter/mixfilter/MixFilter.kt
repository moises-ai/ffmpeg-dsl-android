package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.mixfilter

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.Filter

abstract class MixFilter: Filter() {
    override val value: String
        get() = generateMixFilterAsString()
    private val mixFilters: MutableList<Filter> = mutableListOf()

    private fun generateMixFilterAsString(): String {
        return mixFilters.joinToString(":") { it.toString() }
    }

    fun addFilter(filter: Filter) {
        mixFilters.add(filter)
    }
}