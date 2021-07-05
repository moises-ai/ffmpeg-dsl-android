package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.streamspecifier


/**
 * Created by Vinícius Veríssimo on 05/07/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 *
 * @see https://ffmpeg.org/ffmpeg.html#Stream-specifiers-1
 */
enum class StreamType(val id: String) {
    Video("v"),
    Audio("a"),
    Subtitle("s"),
    Data("d"),
    Attachment("t")
}