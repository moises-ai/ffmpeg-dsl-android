package ai.moises.ffmpegdslandroid.ffmpegcommand

import ai.moises.ffmpegdslandroid.ffmpegcommand.command.CommandBuilder
import ai.moises.ffmpegdslandroid.ffmpegcommand.initializer.FFmpegCommandInitializer

fun ffmpegCommand(initializer: FFmpegCommandInitializer.() -> Unit): String {
    val commandBuilder = CommandBuilder()

    FFmpegCommandInitializer(commandBuilder).apply(initializer)

    return commandBuilder.build()
}