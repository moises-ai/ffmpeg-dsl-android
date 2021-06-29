package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.initializer

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument.InputArgument
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument.InputTimeOffset
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument.SeekStartArgument
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument.TimeArgument
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.CommandArgumentParser
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.timeduration.TimeDuration

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
        destination.add(InputTimeOffset(timeDuration))
    }
}