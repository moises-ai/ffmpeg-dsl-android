package ai.moises.ffmpegdslandroid.ffmpegcommand.filter

import ai.moises.ffmpegdslandroid.ffmpegcommand.assertion.KeyAssertion
import ai.moises.ffmpegdslandroid.ffmpegcommand.assertion.ValueAssertion
import ai.moises.ffmpegdslandroid.ffmpegcommand.command.CommandArgumentParser
import ai.moises.ffmpegdslandroid.ffmpegcommand.command.KeyCommandArgument
import ai.moises.ffmpegdslandroid.ffmpegcommand.command.ValueCommandArgument

abstract class Filter: KeyCommandArgument, ValueCommandArgument, CommandArgumentParser {
    override fun parseToString(): String {
        val trimmedKey = key.trim()
        val trimmedValue = value.trim()

        KeyAssertion.assert(trimmedKey)
        ValueAssertion.assert(trimmedValue)

        return "${trimmedKey}=${trimmedValue}"
    }

    override fun toString(): String =
        parseToString()
}