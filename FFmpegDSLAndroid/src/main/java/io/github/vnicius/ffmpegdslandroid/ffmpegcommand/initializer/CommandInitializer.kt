package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.initializer

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.annotation.FFmpegInitializerMarker
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument.Argument

@FFmpegInitializerMarker
open class CommandInitializer {
    protected val arguments: MutableList<Argument> = mutableListOf()

    fun getArgumentsList(): List<Argument> = arguments
}