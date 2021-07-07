package ai.moises.ffmpegdslandroid.ffmpegcommand.initializer

import ai.moises.ffmpegdslandroid.ffmpegcommand.filter.Filter
import ai.moises.ffmpegdslandroid.ffmpegcommand.filter.FilterGroup

class FilterGroupInitializer(private val filterGroup: FilterGroup) : BaseFiltersInitializer() {

    override fun addFilter(filter: Filter) {
        filterGroup.addFilter(filter)
    }
}