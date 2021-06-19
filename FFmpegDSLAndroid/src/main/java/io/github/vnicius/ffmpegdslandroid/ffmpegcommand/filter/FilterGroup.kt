package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.CommandArgumentParser

class FilterGroup(var inputTag: String? = null, var outputTag: String? = null): CommandArgumentParser {
    private val filters: MutableList<Filter> = mutableListOf()

    fun addFilter(filter: Filter) {
        filters.add(filter)
    }

    override fun parseToString(): String {
        val filtersString = filters.joinToString(",") { it.parseToString() }
        val inTag = inputTag ?: ""
        val outTag = outputTag ?: ""

        return "$inTag$filtersString$outTag;"
    }

    override fun toString(): String =
        parseToString()
}