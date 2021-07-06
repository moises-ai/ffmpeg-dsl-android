package io.github.vnicius.ffmpegdslandroid

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.ffmpegCommand
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.FilterGroup
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.panfilter.ChannelType
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.initializer.minutes
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.initializer.seconds
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.streamspecifier.StreamSpecifier
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.streamspecifier.StreamType
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.timeduration.Duration

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val command = ffmpegCommand {
            isOverrideAllowed = true

            input {
                seekStart = minutes(2)
                path = "test.mp3"
                inputTimeOffset = seconds(0.3102834467120186)
            }

            input {
                seekStart = minutes(2)
                path = "test_2.mp3"
            }

            filterComplex {
                val filterGroups = mutableListOf<FilterGroup>()

                filterGroup(
                    StreamSpecifier(0, StreamType.Audio),
                    StreamSpecifier(StreamType.Audio, 0)
                ) {
                    volume = 1.2f
                    pan {
                        channelType = ChannelType.Stereo
                        gains = floatArrayOf(1f, 0f)
                    }
                }.also(filterGroups::add)

                filterGroup(
                    StreamSpecifier(1, StreamType.Audio),
                    StreamSpecifier(StreamType.Audio, 1)
                ) {
                    volume = 1.5f
                    pan {
                        channelType = ChannelType.Stereo
                        gains = floatArrayOf(0f, 1f)
                    }
                }.also(filterGroups::add)

                amix(
                    filterGroups.mapNotNull { it.outputStreamSpecifier },
                    StreamSpecifier(StreamType.Audio, 3)
                ) {
                    inputs = 2
                    duration = Duration.Longest
                    dropoutTransition = 2
                    volume = 2
                }
            }

            map(tag(StreamSpecifier(StreamType.Audio, 3)))

            outputPath = "out.mp3"
        }

        findViewById<TextView>(R.id.text_view).text = command

        Log.d("command", command)
    }
}