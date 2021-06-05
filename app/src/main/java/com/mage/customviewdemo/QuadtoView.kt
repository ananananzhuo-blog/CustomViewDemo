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
        end.x = measuredWidth - 30f
        end.y = measuredHeight - 30f
        control.x = measuredWidth / 2f - 50
        control.y = measuredHeight / 2f + 50
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
            drawCircle(control.x, control.y, 20f, paint)
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
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    if (abs(it.x - lastX) < 20 && abs(it.y - lastY) < 20) {
                        lastX = event.x
                        lastY = event.y
                        isDragging = true
                    }

                }
                MotionEvent.ACTION_MOVE -> {
                    if (isDragging) {
                        control.x = control.x + (event.x - lastX)
                        control.y = control.y + (event.y - lastY)
                        postInvalidate()
                    }

                }
                MotionEvent.ACTION_UP -> {
                    isDragging = false
//                    if (isDragging) {
//                        lastX = 0
//                        lastY = 0
//                        isDragging = false
//                    }

                }
            }
        }
        return true
    }

}