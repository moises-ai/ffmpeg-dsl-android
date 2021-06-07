package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.Filter
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.FilterGroup

class FilterComplexArgument: Argument() {
    override val key: String = "-filter_complex"
    override val value: String
        get() = getContentAsString()

    private var filtersGroups: MutableList<FilterGroup> = mutableListOf()
    private val filters: MutableList<Filter> = mutableListOf()

    private fun getFilterGroupsAsString(): String {
        val groups = filtersGroups.mapIndexed { index, filterGroup ->
            if (filterGroup.inputTag.isNullOrBlank()) {
                filterGroup.inputTag = "[$index:a]"
            }

            if (filterGroup.outputTag.isNullOrBlank()) {
                filterGroup.outputTag = "[a:$index]"
            }

            filterGroup.toString()
        }
        val filtersGroupsConcat = groups.joinToString("")
        val filtersGroupsTags = filtersGroups.joinToString("") { it.outputTag ?: "" }

        return filtersGroupsConcat + filtersGroupsTags
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
}