package io.github.vnicius.ffmpegdslandroid.ffmpegcommand

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.CommandBuilder
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.initializer.FFmpegCommandInitializer

fun ffmpegCommand(initializer: FFmpegCommandInitializer.() -> Unit): String {
    val ffmpegCommandInitializer = FFmpegCommandInitializer()
    val commandBuilder = CommandBuilder()

    ffmpegCommandInitializer.initializer()

    ffmpegCommandInitializer.getArgumentsList().forEach {
        commandBuilder.addArgument(it)
    }

    return commandBuilder.toString()
}