package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument.Argument

abstract class Flag : Argument() {
    override val value: String = ""
}