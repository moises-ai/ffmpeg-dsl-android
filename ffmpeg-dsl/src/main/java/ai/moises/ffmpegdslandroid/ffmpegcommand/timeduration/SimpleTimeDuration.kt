package ai.moises.ffmpegdslandroid.ffmpegcommand.timeduration

import ai.moises.ffmpegdslandroid.ffmpegcommand.timeduration.timedurationunit.TimeDurationUnit


/**
 * Created by Vinícius Veríssimo on 28/06/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class SimpleTimeDuration private constructor(): TimeDuration {

    private var timeDurationString: String = ""

    constructor(value: Number, timeDurationUnit: TimeDurationUnit) : this() {
        timeDurationString = timeDurationUnit.format(value)
    }

    override fun format(): String = timeDurationString
}