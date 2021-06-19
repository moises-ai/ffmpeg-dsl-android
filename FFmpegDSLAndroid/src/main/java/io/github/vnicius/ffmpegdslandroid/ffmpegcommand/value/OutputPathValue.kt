package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.value

class OutputPathValue(path: String) : Value() {
    override val value: String = "\"$path\""
}