package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter


/**
 * Created by Vinícius Veríssimo on 23/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
interface TaggedFilter {
    val inputTag: String
    val outputTag: String
}