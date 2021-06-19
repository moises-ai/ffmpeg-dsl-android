package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.initializer

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument.FilterComplexArgument
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.CommandArgumentParser
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.flag.OverrideAllowedFlag
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.value.OutputPathValue

class FFmpegCommandInitializer: CommandInitializer() {
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

    private fun addIsOverrideAllowed(isAllowed: Boolean) {
        commandArguments.add(OverrideAllowedFlag(isAllowed))
    }

    private fun addOutputPathValue(path: String) {
        commandArguments.add(OutputPathValue(path))
    }

    fun input(initializer: InputCommandInitializer.() -> Unit): List<CommandArgumentParser> {
        val inputCommandInitializer = InputCommandInitializer().apply(initializer)
        val argumentsList = inputCommandInitializer.getArgumentsList()

        commandArguments.addAll(argumentsList)

        return argumentsList
    }

    fun filterComplex(initializer: FilterComplexInitializer.() -> Unit): FilterComplexArgument {
        val filterComplexInitializer = FilterComplexInitializer().apply(initializer)
        val filterComplexArgument = filterComplexInitializer.filterComplexArgument

        commandArguments.add(filterComplexArgument)

        return filterComplexArgument
    }
}