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
class DrawArcView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    val paint = Paint().apply {
        color = Color.RED
        strokeWidth = 10f

    }
    val oval = RectF(200f, 200f, 500f, 500f)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawArc(oval, 0f, 120f, false, paint)
        canvas?.translate(0f,400f)
        canvas?.drawArc(oval, 0f, 120f, true, paint)
    }
}