package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.extension


/**
 * Created by Vinícius Veríssimo on 28/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */

fun Number.compress(): Number {
    val intPart = this.toInt()

    return if (this is Float && this - intPart == 0f) {
        intPart
    } else {
        this
    }
}

fun Number.formatToTime(): String {
    val intValue = this.toInt()

    return if (intValue in -10..10) {
        "0${this}"
    } else {
        this.toString()
    }
}