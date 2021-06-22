package io.github.vnicius.ffmpegdslandroid

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.ffmpegCommand
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.Duration
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter.panfilter.ChannelType

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val command = ffmpegCommand {
            isOverrideAllowed = true

            input {
                seekStartSeconds = 2f
                path = "test.mp3"
            }

            input {
                path = "test_2.mp3"
            }

            filterComplex {
                filterGroup {
                    volume = 1.2f
                    pan {
                        channelType = ChannelType.Stereo
                        gains = floatArrayOf(1f, .5f)
                    }
                }

                filterGroup {
                    volume = .5f
                    pan {
                        channelType = ChannelType.Stereo
                        gains = floatArrayOf(0f, .2f)
                    }
                }

                amix {
                    inputs = 2
                    duration = Duration.Shortest
                    dropoutTransition = 2
                }
            }

            codec {
                streamSpecifier = "a:0"
                codec = "libcodec"
            }

            outputPath = "out.mp3"
        }

        findViewById<TextView>(R.id.text_view).text = command
    }
}