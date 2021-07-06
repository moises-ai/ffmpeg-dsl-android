package ai.moises.ffmpegdslandroid.ffmpegcommand.initializer

import ai.moises.ffmpegdslandroid.ffmpegcommand.argument.InputArgument
import ai.moises.ffmpegdslandroid.ffmpegcommand.argument.InputTimeOffsetArgument
import ai.moises.ffmpegdslandroid.ffmpegcommand.argument.SeekStartArgument
import ai.moises.ffmpegdslandroid.ffmpegcommand.argument.TimeArgument
import ai.moises.ffmpegdslandroid.ffmpegcommand.command.CommandArgumentParser
import ai.moises.ffmpegdslandroid.ffmpegcommand.timeduration.TimeDuration

class InputCommandInitializer(private val destination: MutableList<CommandArgumentParser>) {
    var path: String = ""
        set(value) {
            field = value
            addInputArgument(path)
        }
    var seekStart: TimeDuration? = null
        set(value) {
            field = value
            value?.let(::addSeekStartArgument)
        }
    var duration: TimeDuration? = null
        set(value) {
            field = value
            value?.let(::addTimeArgument)
        }
    var inputTimeOffset: TimeDuration? = null
        set(value) {
            field = value
            value?.let(::addInputTimeOffsetArgument)
        }

    private fun addInputArgument(path: String) {
        destination.add(InputArgument(path))
    }

    private fun addSeekStartArgument(timeDuration: TimeDuration) {
        destination.add(SeekStartArgument(timeDuration))
    }

    private fun addTimeArgument(timeDuration: TimeDuration) {
        destination.add(TimeArgument(timeDuration))
    }

    private fun addInputTimeOffsetArgument(timeDuration: TimeDuration) {
        destination.add(InputTimeOffsetArgument(timeDuration))
    }
}