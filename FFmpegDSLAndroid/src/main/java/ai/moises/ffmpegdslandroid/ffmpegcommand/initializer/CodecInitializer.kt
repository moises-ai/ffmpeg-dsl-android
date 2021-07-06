package ai.moises.ffmpegdslandroid.ffmpegcommand.initializer

import ai.moises.ffmpegdslandroid.ffmpegcommand.annotation.FFmpegInitializerMarker
import ai.moises.ffmpegdslandroid.ffmpegcommand.streamspecifier.StreamSpecifier


/**
 * Created by Vinícius Veríssimo on 21/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
@FFmpegInitializerMarker
class CodecInitializer {
    var streamSpecifier: StreamSpecifier? = null
    var codec: String = ""
}