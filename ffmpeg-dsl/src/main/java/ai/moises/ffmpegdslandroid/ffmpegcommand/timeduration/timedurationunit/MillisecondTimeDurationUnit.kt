package ai.moises.ffmpegdslandroid.ffmpegcommand.timeduration.timedurationunit

import ai.moises.ffmpegdslandroid.ffmpegcommand.extension.compress


/**
 * Created by Vinícius Veríssimo on 28/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class MillisecondTimeDurationUnit: TimeDurationUnit {
    override fun format(value: Number): String {
        return "${value.compress()}ms"
    }
}