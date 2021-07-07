package ai.moises.ffmpegdslandroid.ffmpegcommand.flag

class OverrideAllowedFlag(private val isOverrideAllowed: Boolean): Flag() {
    override val key: String
        get() = if (isOverrideAllowed) {
            "-y"
        } else {
            "-n"
        }
}