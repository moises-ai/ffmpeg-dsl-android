package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter

class InputsFilter(inputsSize: Int): Filter() {
    override val key: String = "inputs"
    override val value: String = inputsSize.toString()
}