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
class PaintJoinView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    val paint = Paint()
    val path = Path()
    val step=300f
    init {
        paint.strokeWidth=40f
    }
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.color=Color.RED
        paint.style=Paint.Style.STROKE
        paint.strokeJoin=Paint.Join.BEVEL
        path.reset()
        path.moveTo(80f,80f)
        path.lineTo(300f,80f)
        path.lineTo(300f,300f)
        path.close()
        canvas?.drawPath(path, paint)


        paint.color=Color.RED
        paint.style=Paint.Style.STROKE
        paint.strokeJoin=Paint.Join.MITER
        path.reset()
        path.moveTo(80f,80f+step)
        path.lineTo(300f,80f+step)
        path.lineTo(300f,300f+step)
        path.close()
        canvas?.drawPath(path, paint)


        paint.color=Color.RED
        paint.style=Paint.Style.STROKE
        paint.strokeJoin=Paint.Join.ROUND
        path.reset()
        path.moveTo(80f,80f+step*2)
        path.lineTo(300f,80f+step*2)
        path.lineTo(300f,300f+step*2)
        path.close()
        canvas?.drawPath(path, paint)
    }
}