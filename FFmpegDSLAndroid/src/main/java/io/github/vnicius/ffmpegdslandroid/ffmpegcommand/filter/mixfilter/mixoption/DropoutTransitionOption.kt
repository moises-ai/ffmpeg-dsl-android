package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.mixfilter.mixoption

class DropoutTransitionOption(dropoutTransition: Int): MixOption() {
    override val key: String = "dropout_transition"
    override val value: String = dropoutTransition.toString()
}