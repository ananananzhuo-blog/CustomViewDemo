package com.mage.customviewdemo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

/**
 * author  :mayong
 * function:
 * date    :2021/6/7
 **/
class DrawRectView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    val rect = RectF(200f,200f,500f,500f)
    val paint = Paint().apply {
        color= Color.RED
        strokeWidth=10f
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.apply {
            drawRect(rect, paint)
            translate(0f,500f)
            drawRoundRect(rect,60f,80f,paint)
        }
    }
}