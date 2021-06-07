package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.initializer

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument.InputArgument
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument.SeekStartArgument
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument.TimeArgument

class InputCommandInitializer : CommandInitializer() {
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
        arguments.add(InputArgument(path))
    }

    private fun addSeekStartSecondArgument(second: Float) {
        arguments.add(SeekStartArgument().apply {
            setPosition(second)
        })
    }

    private fun addTimeSecondArgument(second: Float) {
        arguments.add(TimeArgument().apply {
            setPosition(second)
        })
    }
}