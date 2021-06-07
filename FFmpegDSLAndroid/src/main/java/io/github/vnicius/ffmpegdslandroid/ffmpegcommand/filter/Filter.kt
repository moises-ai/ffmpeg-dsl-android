package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter

abstract class Filter {
    abstract val key: String
    abstract val value: String

    override fun toString(): String {
        return "$key=$value"
    }
}