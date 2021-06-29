package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.timeduration


/**
 * Created by Vinícius Veríssimo on 28/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 *
 * @see https://ffmpeg.org/ffmpeg-utils.html#time-duration-syntax
 */
interface TimeDuration {
    fun format(): String
}