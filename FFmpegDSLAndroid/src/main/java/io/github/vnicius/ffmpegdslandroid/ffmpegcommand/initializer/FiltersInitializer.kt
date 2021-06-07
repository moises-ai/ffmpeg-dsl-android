package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.initializer

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.Filter

class FiltersInitializer: BaseFiltersInitializer() {
    private val mutableFilters: MutableList<Filter> = mutableListOf()
    val filters: List<Filter> = mutableFilters

    override fun addFilter(filter: Filter) {
        mutableFilters.add(filter)
    }
}