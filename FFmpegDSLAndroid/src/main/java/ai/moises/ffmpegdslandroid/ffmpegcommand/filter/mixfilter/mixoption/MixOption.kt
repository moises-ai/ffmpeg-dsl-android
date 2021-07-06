package ai.moises.ffmpegdslandroid.ffmpegcommand.filter.mixfilter.mixoption

import ai.moises.ffmpegdslandroid.ffmpegcommand.command.CommandArgumentParser
import ai.moises.ffmpegdslandroid.ffmpegcommand.command.KeyCommandArgument
import ai.moises.ffmpegdslandroid.ffmpegcommand.command.ValueCommandArgument


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