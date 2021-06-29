package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.exception

import java.util.concurrent.TimeUnit


/**
 * Created by Vinícius Veríssimo on 28/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class InvalidTimeException(private val timeUnit: TimeUnit, val value: Number) :
    Exception("The value $value to \"${timeUnit.name}\" is not valid")