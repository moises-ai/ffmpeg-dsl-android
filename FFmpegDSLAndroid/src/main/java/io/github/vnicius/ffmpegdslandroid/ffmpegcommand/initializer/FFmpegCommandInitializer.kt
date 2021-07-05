package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.initializer

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument.CodecArgument
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument.FilterComplexArgument
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument.MapArgument
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.CommandArgumentParser
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.CommandBuilder
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.FilterTagGenerator
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.flag.OverrideAllowedFlag
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.streamspecifier.StreamSpecifier
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.value.OutputPathValue

class FFmpegCommandInitializer(private val commandBuilder: CommandBuilder) {
    var isOverrideAllowed: Boolean? = null
        set(value) {
            field = value
            value?.let(::addIsOverrideAllowed)
        }
    var outputPath: String? = null
        set(value) {
            field = value
            value?.let(::addOutputPathValue)
        }
    var map: String? = null
        set(value) {
            field = value
            value?.let(::addMapArgument)
        }

    private fun addIsOverrideAllowed(isAllowed: Boolean) {
        commandBuilder.addArgument(OverrideAllowedFlag(isAllowed))
    }

    private fun addOutputPathValue(path: String) {
        commandBuilder.addArgument(OutputPathValue(path))
    }

    private fun addMapArgument(streamSpecifier: String) {
        commandBuilder.addArgument(MapArgument(streamSpecifier))
    }

    fun input(initializer: InputCommandInitializer.() -> Unit): List<CommandArgumentParser> {
        val destinationList = mutableListOf<CommandArgumentParser>()

        InputCommandInitializer(destinationList).apply(initializer)

        destinationList.forEach {
            commandBuilder.addArgument(it)
        }

        return destinationList
    }

    fun filterComplex(initializer: FilterComplexInitializer.() -> Unit): FilterComplexArgument {
        val filterComplexArgument = FilterComplexArgument()

        FilterComplexInitializer(filterComplexArgument).apply(initializer)

        commandBuilder.addArgument(filterComplexArgument)

        return filterComplexArgument
    }

    fun codec(initializer: CodecInitializer.() -> Unit): CodecArgument {
        val codecInitializer = CodecInitializer().apply(initializer)
        val codecArgument = CodecArgument(codecInitializer.codec, codecInitializer.streamSpecifier)

        commandBuilder.addArgument(codecArgument)

        return codecArgument
    }

    fun tag(streamSpecifier: StreamSpecifier): String =
        FilterTagGenerator().generateTagFromStreamSpecifier(streamSpecifier)
}