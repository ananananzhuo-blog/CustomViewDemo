package com.mage.customviewdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_base).setOnClickListener {
            startActivity(Intent(this,CustomViewActivity::class.java))
        }
        findViewById<Button>(R.id.btn_pathop).setOnClickListener {
            startActivity(Intent(this,PathOpActivity::class.java))
        }
        findViewById<Button>(R.id.btn_arcto).setOnClickListener {
            startActivity(Intent(this,ArcToActivity::class.java))
        }
    }
}