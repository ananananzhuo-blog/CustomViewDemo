package com.mage.customviewdemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mage.customviewdemo.R
import com.mage.customviewdemo.view.PaintStrokeMiterView

class PaintStrokeMiterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paint_stroke_miter)
        val paintStrokeMiterView = findViewById<PaintStrokeMiterView>(R.id.paint_stroke_miterview)

    }
}