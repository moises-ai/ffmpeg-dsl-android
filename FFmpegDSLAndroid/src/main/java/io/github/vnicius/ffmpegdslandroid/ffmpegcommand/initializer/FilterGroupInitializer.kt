package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.initializer

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.Filter
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.FilterGroup

class FilterGroupInitializer(private val filterGroup: FilterGroup) : BaseFiltersInitializer() {

    override fun addFilter(filter: Filter) {
        filterGroup.addFilter(filter)
    }
}