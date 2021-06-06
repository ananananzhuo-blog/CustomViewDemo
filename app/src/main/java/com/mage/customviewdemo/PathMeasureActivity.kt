package com.mage.customviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mage.customviewdemo.view.view.PathMeasureView

class PathMeasureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_path_measure)
        val pathMeasureView = findViewById<PathMeasureView>(R.id.pathmeasure)
        findViewById<Button>(R.id.btn_startpathmeasure).setOnClickListener {
            pathMeasureView.startAnim()
        }
    }
}