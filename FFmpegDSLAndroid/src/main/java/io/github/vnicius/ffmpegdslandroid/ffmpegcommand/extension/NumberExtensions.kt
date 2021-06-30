package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.extension

import kotlin.math.abs


/**
 * Created by Vinícius Veríssimo on 28/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */

fun Number.compress(): Number {
    val intPart = this.toInt()
    val compressedValue = when {
        (this is Float && this - intPart == 0f) -> intPart
        (this is Double && this - intPart == 0.0) -> intPart
        else -> this
    }

    return compressedValue
}

fun Number.formatToTime(): String {
    val absLongValue = abs(this.toLong())

    if (absLongValue >= 10) {
        return this.toString()
    }

    val absValue = when(this) {
        is Double -> abs(this)
        is Float -> abs(this)
        else -> absLongValue
    }
    val stringValue = "0$absValue"
    val signal = if (this.toInt() < 0) {
        "-"
    } else {
        ""
    }

    return signal + stringValue
}