package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.CommandArgumentParser
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.KeyCommandArgument
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.ValueCommandArgument

abstract class Argument : KeyCommandArgument, ValueCommandArgument, CommandArgumentParser {
    override fun parseToString(): String {
        return "$key $value".trim()
    }

    override fun toString(): String {
        return parseToString()
    }
}