package ai.moises.ffmpegdslandroid.ffmpegcommand.initializer

import ai.moises.ffmpegdslandroid.ffmpegcommand.argument.CodecArgument
import ai.moises.ffmpegdslandroid.ffmpegcommand.argument.FilterComplexArgument
import ai.moises.ffmpegdslandroid.ffmpegcommand.argument.MapArgument
import ai.moises.ffmpegdslandroid.ffmpegcommand.command.CommandArgumentParser
import ai.moises.ffmpegdslandroid.ffmpegcommand.command.CommandBuilder
import ai.moises.ffmpegdslandroid.ffmpegcommand.filter.FilterTagGenerator
import ai.moises.ffmpegdslandroid.ffmpegcommand.flag.OverrideAllowedFlag
import ai.moises.ffmpegdslandroid.ffmpegcommand.streamspecifier.StreamSpecifier
import ai.moises.ffmpegdslandroid.ffmpegcommand.value.OutputPathValue

class FFmpegCommandInitializer(private val commandBuilder: CommandBuilder) {
    var isOverrideAllowed: Boolean? = null
        set(value) {
            field = value
            value?.let(::addIsOverrideAllowed)
        }
    var outputPath: String? = null
        set(value) {
            field = value
            value?.let(::addOutputPathValue)
        }

    private fun addIsOverrideAllowed(isAllowed: Boolean) {
        commandBuilder.addArgument(OverrideAllowedFlag(isAllowed))
    }

    private fun addOutputPathValue(path: String) {
        commandBuilder.addArgument(OutputPathValue(path))
    }

    private fun addMapArgument(streamSpecifier: StreamSpecifier) {
        commandBuilder.addArgument(MapArgument(streamSpecifier))
    }

    fun input(initializer: InputCommandInitializer.() -> Unit): List<CommandArgumentParser> {
        val destinationList = mutableListOf<CommandArgumentParser>()

        InputCommandInitializer(destinationList).apply(initializer)

        destinationList.forEach {
            commandBuilder.addArgument(it)
        }

        return destinationList
    }

    fun filterComplex(initializer: FilterComplexInitializer.() -> Unit): FilterComplexArgument {
        val filterComplexArgument = FilterComplexArgument()

        FilterComplexInitializer(filterComplexArgument).apply(initializer)

        commandBuilder.addArgument(filterComplexArgument)

        return filterComplexArgument
    }

    fun codec(initializer: CodecInitializer.() -> Unit): CodecArgument {
        val codecInitializer = CodecInitializer().apply(initializer)
        val codecArgument = CodecArgument(codecInitializer.codec, codecInitializer.streamSpecifier)

        commandBuilder.addArgument(codecArgument)

        return codecArgument
    }

    fun tag(streamSpecifier: StreamSpecifier): String =
        FilterTagGenerator().generateTagFromStreamSpecifier(streamSpecifier)

    fun map(streamSpecifier: StreamSpecifier): MapArgument {
        val mapArgument = MapArgument(streamSpecifier)

        commandBuilder.addArgument(mapArgument)

        return mapArgument;
    }

    fun map(streamSpecifier: String): MapArgument {
        val mapArgument = MapArgument(streamSpecifier)

        commandBuilder.addArgument(mapArgument)

        return mapArgument;
    }
}