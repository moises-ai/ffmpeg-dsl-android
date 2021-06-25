package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.value

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.CommandArgumentParser
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.ValueCommandArgument

abstract class Value: ValueCommandArgument, CommandArgumentParser {
    override fun parseToString(): String =
        "\"${value.trim()}\""

    override fun toString(): String =
        parseToString()
}