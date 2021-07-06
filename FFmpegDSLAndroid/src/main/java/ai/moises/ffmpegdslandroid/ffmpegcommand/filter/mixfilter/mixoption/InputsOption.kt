package ai.moises.ffmpegdslandroid.ffmpegcommand.filter.mixfilter.mixoption

class InputsOption(inputsSize: Int): MixOption() {
    override val key: String = "inputs"
    override val value: String = inputsSize.toString()
}