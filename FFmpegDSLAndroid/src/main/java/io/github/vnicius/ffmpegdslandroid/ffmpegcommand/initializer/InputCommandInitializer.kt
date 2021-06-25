package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.initializer

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument.InputArgument
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument.SeekStartArgument
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument.TimeArgument
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.CommandArgumentParser

class InputCommandInitializer(private val destination: MutableList<CommandArgumentParser>) {
    var path: String = ""
        set(value) {
            field = value
            addInputArgument(path)
        }
    var seekStartSeconds: Float? = null
        set(value) {
            field = value
            value?.let(::addSeekStartSecondArgument)
        }
    var timeSeconds: Float? = null
        set(value) {
            field = value
            value?.let(::addTimeSecondArgument)
        }

    private fun addInputArgument(path: String) {
        destination.add(InputArgument(path))
    }

    private fun addSeekStartSecondArgument(second: Float) {
        destination.add(SeekStartArgument().apply {
            setPosition(second)
        })
    }

    private fun addTimeSecondArgument(second: Float) {
        destination.add(TimeArgument().apply {
            setPosition(second)
        })
    }
}