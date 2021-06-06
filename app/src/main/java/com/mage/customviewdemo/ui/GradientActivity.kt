package com.mage.customviewdemo.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.appcompat.widget.ListPopupWindow
import com.mage.customviewdemo.R
import com.mage.customviewdemo.view.GradientView

class GradientActivity : AppCompatActivity() {
    private var gradientView: GradientView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gradient)
         gradientView = findViewById<GradientView>(R.id.gradientview)
        val btn = findViewById<Button>(R.id.btn_gradient1)
        btn.setOnClickListener {
            showPop()
        }
    }

    private fun showPop() {
        val pop: ListPopupWindow = ListPopupWindow(this)
        pop.width = resources.displayMetrics.widthPixels
        pop.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val datas = listOf<String>(
            "LinearGradient",
            "RadialGradient",
            "SweepGradient",
            "BitmapShader",
            "ComposeShader"
        )
        pop.setAdapter(ArrayAdapter<String>(this, R.layout.item, R.id.tv_item, datas))
        pop.setOnItemClickListener { parent, view, position, id ->
            gradientView?.setShaderText(datas[position])
            pop.dismiss()
        }
        pop.show()

    }
}