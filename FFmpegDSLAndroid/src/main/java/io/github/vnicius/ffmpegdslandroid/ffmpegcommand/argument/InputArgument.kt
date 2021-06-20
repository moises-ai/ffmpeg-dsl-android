package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.assertion.PathAssertion


class InputArgument(path: String): Argument() {
    override val key: String = "-i"
    override val value: String = "\"$path\""

    init {
        PathAssertion().assert(path)
    }
}