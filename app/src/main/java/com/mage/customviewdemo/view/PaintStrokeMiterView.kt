package com.mage.customviewdemo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * author  :mayong
 * function:
 * date    :2021/6/6
 **/
class PaintStrokeMiterView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    val path = Path()
    val paint = Paint()
    init {
        paint.apply {
            color= Color.RED
            strokeWidth=30f
            strokeJoin=Paint.Join.MITER
        }
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

    }
}