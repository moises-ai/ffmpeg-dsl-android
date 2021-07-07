package ai.moises.ffmpegdslandroid.ffmpegcommand.streamspecifier


/**
 * Created by Vinícius Veríssimo on 05/07/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 *
 * @see https://ffmpeg.org/ffmpeg.html#Stream-specifiers-1
 */
class StreamSpecifier private constructor() {

    private var streamIndex: Int? = null
    private var streamType: StreamType? = null
    private var additionalStreamSpecifier: Int? = null
    private var customAdditionalStreamSpecifier: String = ""

    constructor(
        streamIndex: Int,
        streamType: StreamType,
        additionalStreamSpecifier: Int? = null
    ) : this() {
        this.streamIndex = streamIndex
        this.streamType = streamType
        this.additionalStreamSpecifier = additionalStreamSpecifier
    }

    constructor(streamType: StreamType, additionalStreamSpecifier: Int? = null) : this() {
        this.streamType = streamType
        this.additionalStreamSpecifier = additionalStreamSpecifier
    }

    constructor(streamType: StreamType, customAdditionalStreamSpecifier: String) : this() {
        this.streamType = streamType
        this.customAdditionalStreamSpecifier = customAdditionalStreamSpecifier
    }


    fun parseToString(): String {
        val resultString = StringBuilder()

        streamIndex?.let {
            resultString.append(it).append(":")
        }

        streamType?.let {
            resultString.append(it.id)
        }

        additionalStreamSpecifier?.let {
            resultString.append(":").append(it)
        }

        resultString.append(customAdditionalStreamSpecifier)

        return resultString.toString()
    }

    override fun toString(): String = parseToString()
}