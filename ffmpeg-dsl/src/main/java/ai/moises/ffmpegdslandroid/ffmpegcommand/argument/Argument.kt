package ai.moises.ffmpegdslandroid.ffmpegcommand.argument

import ai.moises.ffmpegdslandroid.ffmpegcommand.assertion.KeyAssertion
import ai.moises.ffmpegdslandroid.ffmpegcommand.assertion.ValueAssertion
import ai.moises.ffmpegdslandroid.ffmpegcommand.command.CommandArgumentParser
import ai.moises.ffmpegdslandroid.ffmpegcommand.command.KeyCommandArgument
import ai.moises.ffmpegdslandroid.ffmpegcommand.command.ValueCommandArgument

abstract class Argument : KeyCommandArgument, ValueCommandArgument, CommandArgumentParser {
    override fun parseToString(): String {
        KeyAssertion.assert(key)
        ValueAssertion.assert(value)

        return "$key \"$value\"".trim()
    }

    override fun toString(): String {
        return parseToString()
    }
}