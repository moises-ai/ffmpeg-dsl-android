package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument

class OutputPathValue(path: String) : Value() {
    override val value: String = "\"$path\""
}