package ai.moises.ffmpegdslandroid.ffmpegcommand.flag

import ai.moises.ffmpegdslandroid.ffmpegcommand.assertion.KeyAssertion
import ai.moises.ffmpegdslandroid.ffmpegcommand.command.CommandArgumentParser
import ai.moises.ffmpegdslandroid.ffmpegcommand.command.KeyCommandArgument

abstract class Flag : KeyCommandArgument, CommandArgumentParser {
    override fun parseToString(): String {
        val trimmedKey = key.trim()

        KeyAssertion.assert(key)

        return trimmedKey
    }

    override fun toString(): String =
        parseToString()
}