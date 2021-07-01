package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.flag

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.assertion.KeyAssertion
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.CommandArgumentParser
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.KeyCommandArgument

abstract class Flag : KeyCommandArgument, CommandArgumentParser {
    override fun parseToString(): String {
        val trimmedKey = key.trim()

        KeyAssertion.assert(key)

        return trimmedKey
    }

    override fun toString(): String =
        parseToString()
}