package com.mage.customviewdemo.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListPopupWindow
import com.mage.customviewdemo.R
import com.mage.customviewdemo.view.MaskFilterView

class MaskFilterActivity : AppCompatActivity() {
    private var btn: Button? = null
    val datas = listOf<String>("NORMAL", "OUTER", "INNER", "SOLID")
    private var maskFilterView: MaskFilterView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mask_filter)
        btn = findViewById<Button>(R.id.btn_maskfilter)
        maskFilterView = findViewById<MaskFilterView>(R.id.maskfilterview)
        btn?.setOnClickListener {
            showPop()
        }
    }

    private fun showPop() {
        val pop = ListPopupWindow(this)
        pop.width = resources.displayMetrics.widthPixels
        pop.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        pop.anchorView = btn
        pop.setOnItemClickListener { parent, view, position, id ->
            maskFilterView?.setMaskFilter(datas[position])
            pop.dismiss()
        }
        pop.setAdapter(ArrayAdapter<String>(this, R.layout.item, R.id.tv_item, datas))
        pop.show()
    }
}