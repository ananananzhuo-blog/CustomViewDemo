package com.mage.customviewdemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.mage.customviewdemo.R
import com.mage.customviewdemo.view.PathEffectView

class PathEffectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_path_effect)
        val patheffectView = findViewById<PathEffectView>(R.id.path_effect)
        val seekbar = findViewById<SeekBar>(R.id.seekbar_effect)
        seekbar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                patheffectView.corner= (progress*2).toFloat()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
    }
}