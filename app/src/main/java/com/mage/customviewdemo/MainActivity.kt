package com.mage.customviewdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mage.customviewdemo.ui.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_canvas_rotation).setOnClickListener {
            startActivity(Intent(this, CanvasRotationActivity::class.java))
        }
        findViewById<Button>(R.id.btn_canvas_drawlines).setOnClickListener {
            startActivity(Intent(this, CanvasDrawLinesActivity::class.java))
        }
        findViewById<Button>(R.id.btn_canvas_drawarc).setOnClickListener {
            startActivity(Intent(this, DrawArcActivity::class.java))
        }
        findViewById<Button>(R.id.btn_canvas_drawract).setOnClickListener {
            startActivity(Intent(this, DrawRectActivity::class.java))
        }
        findViewById<Button>(R.id.btn_canvas_drawbitmap).setOnClickListener {
            startActivity(Intent(this, DrawBitmapActivity::class.java))
        }
    }
}