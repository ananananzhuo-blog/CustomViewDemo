package com.mage.customviewdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mage.customviewdemo.ui.CanvasRotationActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_canvas_rotation).setOnClickListener {
            startActivity(Intent(this, CanvasRotationActivity::class.java))
        }

    }
}