package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.initializer

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.annotation.FFmpegInitializerMarker
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.CommandArgumentParser

@FFmpegInitializerMarker
open class CommandInitializer {
    protected val commandArguments: MutableList<CommandArgumentParser> = mutableListOf()

    fun getArgumentsList(): List<CommandArgumentParser> = commandArguments
}