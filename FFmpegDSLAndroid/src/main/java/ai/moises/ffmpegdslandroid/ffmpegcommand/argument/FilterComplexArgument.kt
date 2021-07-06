package ai.moises.ffmpegdslandroid.ffmpegcommand.argument

import ai.moises.ffmpegdslandroid.ffmpegcommand.filter.Filter
import ai.moises.ffmpegdslandroid.ffmpegcommand.filter.FilterGroup

class FilterComplexArgument: Argument() {
    override val key: String = "-filter_complex"
    override val value: String
        get() = getContentAsString()

    private var filtersGroups: MutableList<FilterGroup> = mutableListOf()
    private val filters: MutableList<Filter> = mutableListOf()

    private fun getFilterGroupsAsString(): String {
        return filtersGroups.joinToString("") { filterGroup ->
            filterGroup.parseToString()
        }
    }

    private fun getFiltersAsString(): String {
        return filters.joinToString(",") { it.toString() }
    }

    private fun getContentAsString(): String {
        return getFilterGroupsAsString() + getFiltersAsString()
    }

    fun addFilterGroup(filterGroup: FilterGroup) {
        filtersGroups.add(filterGroup)
    }

    fun addFilter(filter: Filter) {
        filters.add(filter)
    }

    fun getFilterGroups(): List<FilterGroup> = filtersGroups
}