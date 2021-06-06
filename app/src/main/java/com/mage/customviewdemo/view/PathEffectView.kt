package com.mage.customviewdemo.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * author  :mayong
 * function:
 * date    :2021/6/6
 **/
class PathEffectView(context: Context?, attrs: AttributeSet?) : View(context, attrs)
{
    var corner=1f
        set(value) {
            field=value
            invalidate()
        }
    val path = Path()
    val paint = Paint()
    init {
        paint.color= Color.RED
        paint.strokeWidth=5f
        paint.style=Paint.Style.STROKE
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        path.reset()
        paint.pathEffect=CornerPathEffect(0f)
        path.apply {
            moveTo(100f,100f)
            lineTo(300f,200f)
            lineTo(100f,400f)
            lineTo(300f,900f)
            lineTo(80f,1000f)
            close()
        }
        canvas?.drawPath(path, paint)

        paint.pathEffect=CornerPathEffect(corner)
        path.offset(500f,0f)
        canvas?.drawPath(path, paint)
    }
}