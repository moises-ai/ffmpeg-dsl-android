package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.argument

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.timeduration.TimeDuration


/**
 * Created by Vinícius Veríssimo on 29/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 *
 * @see https://ffmpeg.org/ffmpeg.html#Main-options
 */
class InputTimeOffset(override val timeDuration: TimeDuration) :
    TimeDurationArgument("-itsoffset") {
}