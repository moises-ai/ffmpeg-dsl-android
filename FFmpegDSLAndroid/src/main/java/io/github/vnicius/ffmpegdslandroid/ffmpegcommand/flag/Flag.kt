package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.flag

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.CommandArgumentParser
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.KeyCommandArgument

abstract class Flag : KeyCommandArgument, CommandArgumentParser {
    override fun parseToString(): String =
        key.trim()

    override fun toString(): String =
        parseToString()
}