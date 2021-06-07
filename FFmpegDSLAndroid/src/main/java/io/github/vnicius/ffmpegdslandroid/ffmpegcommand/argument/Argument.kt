package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument

abstract class Argument {
    abstract val key: String
    abstract val value: String

    override fun toString(): String {
        return "$key $value".trim()
    }
}