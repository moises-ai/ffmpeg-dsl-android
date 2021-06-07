package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.initializer

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.Filter
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.FilterGroup

class FilterGroupInitializer(inputTag: String? = null, outputTag: String? = null) : BaseFiltersInitializer() {
    val filterGroup: FilterGroup = FilterGroup(inputTag, outputTag)

    override fun addFilter(filter: Filter) {
        filterGroup.addFilter(filter)
    }
}