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
        findViewById<Button>(R.id.btn_paintjoin).setOnClickListener {
            startActivity(Intent(this, PaintJoinActivity::class.java))
        }
        findViewById<Button>(R.id.btn_paint_setstrokemiter).setOnClickListener {
            startActivity(Intent(this, PaintStrokeMiterActivity::class.java))
        }
        findViewById<Button>(R.id.pathEffect).setOnClickListener {
            startActivity(Intent(this, PathEffectActivity::class.java))
        }
        findViewById<Button>(R.id.btn_pathdasheffect).setOnClickListener {
            startActivity(Intent(this, PathDashEffectActivity::class.java))
        }
        findViewById<Button>(R.id.btn_gradient).setOnClickListener {
            startActivity(Intent(this, GradientActivity::class.java))
        }
    }
}