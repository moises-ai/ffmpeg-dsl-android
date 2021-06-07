package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument.Argument

abstract class Value: Argument() {
    override val key: String = ""
}