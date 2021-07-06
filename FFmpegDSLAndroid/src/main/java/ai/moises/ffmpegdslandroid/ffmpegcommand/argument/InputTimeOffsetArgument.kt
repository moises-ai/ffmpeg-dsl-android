package ai.moises.ffmpegdslandroid.ffmpegcommand.argument

import ai.moises.ffmpegdslandroid.ffmpegcommand.timeduration.TimeDuration


/**
 * Created by Vinícius Veríssimo on 29/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 *
 * @see https://ffmpeg.org/ffmpeg.html#Main-options
 */
class InputTimeOffsetArgument(override val timeDuration: TimeDuration) :
    TimeDurationArgument("-itsoffset") {
}