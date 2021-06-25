package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.mixfilter.mixoption

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.CommandArgumentParser
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.KeyCommandArgument
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.ValueCommandArgument


/**
 * Created by Vinícius Veríssimo on 23/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
abstract class MixOption : KeyCommandArgument, ValueCommandArgument, CommandArgumentParser {
    override fun parseToString(): String =
        "${key.trim()}=${value.trim()}"

    override fun toString(): String =
        parseToString()
}