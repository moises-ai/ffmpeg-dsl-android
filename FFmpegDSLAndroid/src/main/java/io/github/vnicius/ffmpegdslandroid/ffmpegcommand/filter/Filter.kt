package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.assertion.KeyAssertion
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.assertion.ValueAssertion
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.CommandArgumentParser
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.KeyCommandArgument
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.ValueCommandArgument

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