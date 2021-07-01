package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.flag

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
 * Created by Vinícius Veríssimo on 01/07/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class OverrideAllowedFlagTest {

    @Test
    fun should_ParsePositiveFlag_when_OverrideValueIsTrue() {
        val overrideAllowedFlag = OverrideAllowedFlag(true)

        val parsedFlag = overrideAllowedFlag.parseToString()

        assertThat(parsedFlag).isEqualTo("-y")
    }

    @Test
    fun should_ParseNegativeFlag_when_OverrideValueIsFalse() {
        val overrideAllowedFlag = OverrideAllowedFlag(false)

        val parsedFlag = overrideAllowedFlag.parseToString()

        assertThat(parsedFlag).isEqualTo("-n")
    }
}