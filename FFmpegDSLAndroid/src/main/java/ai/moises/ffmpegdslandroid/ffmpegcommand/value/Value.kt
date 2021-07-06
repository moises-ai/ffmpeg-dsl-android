package ai.moises.ffmpegdslandroid.ffmpegcommand.value

import ai.moises.ffmpegdslandroid.ffmpegcommand.assertion.ValueAssertion
import ai.moises.ffmpegdslandroid.ffmpegcommand.command.CommandArgumentParser
import ai.moises.ffmpegdslandroid.ffmpegcommand.command.ValueCommandArgument

abstract class Value: ValueCommandArgument, CommandArgumentParser {
    override fun parseToString(): String {
        val trimmedValue = value.trim()

        ValueAssertion.assert(trimmedValue)

        return "\"${trimmedValue}\""
    }

    override fun toString(): String =
        parseToString()
}