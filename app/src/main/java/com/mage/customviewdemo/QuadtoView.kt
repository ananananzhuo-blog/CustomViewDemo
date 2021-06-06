package com.mage.customviewdemo

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kotlin.math.abs

/**
 * author  :mayong
 * function:二阶贝塞尔曲线
 * date    :2021/6/5
 **/
class QuadtoView : View {
    var start = PointF()
    var end = PointF()
    var control = PointF()
    var path = Path()
    var paint = Paint()

    init {
        start.x = 30f
        start.y = 30f
        paint.apply {
            color = Color.RED
            strokeWidth = 5f
            isAntiAlias = false
        }

    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val sizeWidth = MeasureSpec.getSize(widthMeasureSpec)
        val sizeHeight = MeasureSpec.getSize(heightMeasureSpec)
        setMeasuredDimension(sizeWidth, sizeHeight)
        start.x = sizeWidth * 0.3f
        start.y = sizeHeight * 0.3f
        end.x = measuredWidth * 0.7f
        end.y = measuredHeight * 0.7f
        control.x = measuredWidth * 0.5f + 30
        control.y = measuredHeight * 0.5f + 30
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        path.reset()
        canvas?.apply {
            save()
            paint.color = Color.RED
            path.fillType = Path.FillType.WINDING
            path.moveTo(start.x, start.y)
            path.quadTo(control.x, control.y, end.x, end.y)
            path.close()
            drawPath(path, paint)
            paint.color = Color.YELLOW
            drawCircle(control.x, control.y, 50f, paint)
            restore()
        }
    }

    var lastX = 0f
    var lastY = 0f
    var isDragging = false
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (lastX == 0f && lastY == 0f) {
            lastY = control.y
            lastX = control.x
        }
        event?.let {
            when (it.action) {
                MotionEvent.ACTION_DOWN -> {
                    if (abs(it.x - lastX) < 50 && abs(it.y - lastY) < 50) {
                        lastX = it.x
                        lastY = it.y
                        isDragging = true
                    }
                }
                MotionEvent.ACTION_MOVE -> {
                    if (isDragging) {
                        control.x = it.x
                        control.y = it.y
                        lastX = it.x
                        lastY = it.y
                        invalidate()
                    }
                }
                MotionEvent.ACTION_UP -> {
                    isDragging = false

                }
            }
        }
        return true
    }

}