package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter

class DropoutTransitionFilter(dropoutTransition: Int): Filter() {
    override val key: String = "dropout_transition"
    override val value: String = dropoutTransition.toString()
}