package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.value

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.assertion.ValueAssertion
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.CommandArgumentParser
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.ValueCommandArgument

abstract class Value: ValueCommandArgument, CommandArgumentParser {
    override fun parseToString(): String {
        val trimmedValue = value.trim()

        ValueAssertion.assert(trimmedValue)

        return "\"${trimmedValue}\""
    }

    override fun toString(): String =
        parseToString()
}