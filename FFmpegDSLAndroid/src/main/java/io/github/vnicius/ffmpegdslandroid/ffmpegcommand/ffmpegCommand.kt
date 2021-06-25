package io.github.vnicius.ffmpegdslandroid.ffmpegcommand

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.CommandBuilder
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.initializer.FFmpegCommandInitializer

fun ffmpegCommand(initializer: FFmpegCommandInitializer.() -> Unit): String {
    val commandBuilder = CommandBuilder()

    FFmpegCommandInitializer(commandBuilder).apply(initializer)

    return commandBuilder.build()
}