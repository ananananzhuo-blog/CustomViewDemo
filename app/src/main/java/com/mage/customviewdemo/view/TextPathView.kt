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
class TextPathView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val text = "测试文本 Test"
        val srcPaint = Paint()
        srcPaint.textSize = 100f
        srcPaint.color = Color.BLACK
        srcPaint.style = Paint.Style.STROKE
        canvas?.drawText(text, 50f, 100f, srcPaint)
        //获取文本路径
        canvas?.translate(0f, 150f)
        val desPath = Path()
        val desPaint = Paint()
        desPaint.textSize = 100f
        desPaint.color = Color.RED
        desPaint.strokeWidth = 5f
        desPaint.style = Paint.Style.STROKE
        srcPaint.getTextPath(text, 0, text.length, 50f, 100f, desPath)
        canvas?.drawPath(desPath, desPaint)
    }
}