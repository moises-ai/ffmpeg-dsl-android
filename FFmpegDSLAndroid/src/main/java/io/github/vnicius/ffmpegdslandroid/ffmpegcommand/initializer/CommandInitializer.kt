package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.initializer

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument.Argument

open class CommandInitializer {
    protected val arguments: MutableList<Argument> = mutableListOf()

    fun getArgumentsList(): List<Argument> = arguments
}