package ai.moises.ffmpegdslandroid.ffmpegcommand.argument

import ai.moises.ffmpegdslandroid.ffmpegcommand.assertion.PathAssertion


class InputArgument(path: String): Argument() {
    override val key: String = "-i"
    override val value: String = path

    init {
        PathAssertion.assert(path)
    }
}