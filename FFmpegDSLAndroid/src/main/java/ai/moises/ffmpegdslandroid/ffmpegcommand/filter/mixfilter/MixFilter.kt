package ai.moises.ffmpegdslandroid.ffmpegcommand.filter.mixfilter

import ai.moises.ffmpegdslandroid.ffmpegcommand.filter.Filter
import ai.moises.ffmpegdslandroid.ffmpegcommand.filter.FilterTagGenerator
import ai.moises.ffmpegdslandroid.ffmpegcommand.filter.TaggedFilter
import ai.moises.ffmpegdslandroid.ffmpegcommand.filter.mixfilter.mixoption.MixOption
import ai.moises.ffmpegdslandroid.ffmpegcommand.streamspecifier.StreamSpecifier

abstract class MixFilter(
    private val filterKey: String,
    private val inputsStreamsSpecifiers: List<StreamSpecifier>? = null,
    outputStreamSpecifier: StreamSpecifier? = null
) : Filter(), TaggedFilter {
    override val key: String
        get() = generateKey()
    override val value: String
        get() = generateMixFilterAsString()
    private val mixFilters: MutableList<Filter> = mutableListOf()
    private val mixOptions: MutableList<MixOption> = mutableListOf()
    private val filterTagGenerator = FilterTagGenerator()

    override val inputTag: String = generateInputSpecifier()
    override val outputTag: String =
        filterTagGenerator.generateTagFromStreamSpecifier(outputStreamSpecifier)

    private fun generateMixFilterAsString(): String {
        val filters = mixFilters.joinToString(",") { it.parseToString() }.takeIf { it.isNotBlank() }
            ?.let { ",$it" }
        val options = mixOptions.joinToString(":") { it.parseToString() }

        return "$options$filters$outputTag"
    }

    private fun generateInputSpecifier(): String {
        return inputsStreamsSpecifiers?.joinToString("") {
            filterTagGenerator.generateTagFromStreamSpecifier(
                it
            )
        } ?: ""
    }

    private fun generateKey(): String = "$inputTag$filterKey"

    fun addFilter(filter: Filter) {
        mixFilters.add(filter)
    }

    fun addOption(mixOption: MixOption) {
        mixOptions.add(mixOption)
    }
}