package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter

class FilterGroup(var inputTag: String? = null, var outputTag: String? = null) {
    private val filters: MutableList<Filter> = mutableListOf()

    fun addFilter(filter: Filter) {
        filters.add(filter)
    }

    override fun toString(): String {
        val filtersString = filters.joinToString(",") { it.toString() }
        val inTag = inputTag ?: ""
        val outTag = outputTag ?: ""

        return "$inTag$filtersString$outTag;"
    }
}