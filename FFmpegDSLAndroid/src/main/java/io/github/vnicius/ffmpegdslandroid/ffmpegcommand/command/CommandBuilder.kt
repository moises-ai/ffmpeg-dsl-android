package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument.Argument

open class CommandBuilder : Argument() {
    override val key: String = ""
    override val value: String
        get() = getArgumentsAsString()

    private val arguments: MutableList<Argument> = mutableListOf()

    fun addArgument(argument: Argument): CommandBuilder {
        arguments.add(argument)
        return this
    }

    private fun getArgumentsAsString(): String =
        arguments.joinToString(" ") {
            it.toString()
        }
}