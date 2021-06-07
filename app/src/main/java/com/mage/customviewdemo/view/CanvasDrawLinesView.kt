package com.mage.customviewdemo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * author  :mayong
 * function:一次绘制多条线的方法
 * date    :2021/6/7
 **/
class CanvasDrawLinesView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    val paint = Paint().apply {
        color= Color.RED
        strokeWidth=10f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.translate(measuredWidth / 2f, measuredHeight / 2f)
        val lines = floatArrayOf(-200f, 200f, 200f, 200f, 200f, -200f, -200f, -200f)
        canvas?.drawLines(lines, paint)
    }
}