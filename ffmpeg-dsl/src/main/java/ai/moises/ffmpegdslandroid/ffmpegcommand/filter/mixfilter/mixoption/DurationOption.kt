package ai.moises.ffmpegdslandroid.ffmpegcommand.filter.mixfilter.mixoption

import ai.moises.ffmpegdslandroid.ffmpegcommand.timeduration.Duration

class DurationOption(duration: Duration): MixOption() {
    override val key: String = "duration"
    override val value: String = duration.value
}