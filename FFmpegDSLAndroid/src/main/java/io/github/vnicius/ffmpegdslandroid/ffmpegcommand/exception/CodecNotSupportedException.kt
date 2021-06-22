package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.exception


/**
 * Created by Vinícius Veríssimo on 21/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class CodecNotSupportedException(codec: String): Exception("The codec '$codec' is not supported")