package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.assertion.KeyAssertion
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.assertion.ValueAssertion
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.CommandArgumentParser
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.KeyCommandArgument
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.ValueCommandArgument

abstract class Argument : KeyCommandArgument, ValueCommandArgument, CommandArgumentParser {
    override fun parseToString(): String {
        KeyAssertion.assert(key)
        ValueAssertion.assert(value)

        return "$key $value".trim()
    }

    override fun toString(): String {
        return parseToString()
    }
}