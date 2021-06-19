package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command


open class CommandBuilder {
    private val arguments: MutableList<CommandArgumentParser> = mutableListOf()

    fun addArgument(argument: CommandArgumentParser): CommandBuilder {
        arguments.add(argument)
        return this
    }

    fun build(): String =
        arguments.joinToString(" ") {
            it.parseToString()
        }
}