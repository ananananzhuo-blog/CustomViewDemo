package com.mage.customviewdemo

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kotlin.math.abs

/**
 * author  :mayong
 * function:三阶贝塞尔曲线
 * date    :2021/6/6
 **/
class CubicToView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private val path = Path()
    private val paint = Paint()
    private val start = PointF()
    private val end = PointF()
    private val controll1 = PointF()//三阶贝塞尔曲线控制点1
    private val controll2 = PointF()//三阶贝塞尔曲线控制点2
    private var lastX1 = 0f
    private var lastY1 = 0f
    private var lastX2 = 0f
    private var lastY2 = 0f
    private var isDraging1 = false//控制点1是否在被拖动
    private var isDraging2 = false//控制点2是否在被拖动

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val sizeWidth = MeasureSpec.getSize(widthMeasureSpec)
        val sizeHeight = MeasureSpec.getSize(heightMeasureSpec)
        setMeasuredDimension(sizeWidth, sizeHeight)
        start.x = sizeWidth * 0.3f
        start.y = sizeHeight * 0.3f
        end.x = sizeWidth * 0.7f
        end.y = sizeHeight * 0.7f
        controll1.x = sizeWidth * 0.4f + 30
        controll1.y = sizeHeight * 0.4f + 30
        controll2.x = sizeWidth * 0.6f + 30
        controll2.y = sizeHeight * 0.6f + 30
        lastX1 = controll1.x
        lastY1 = controll1.y
        lastX2 = controll2.x
        lastY2 = controll2.y
        paint.apply {
            color = Color.RED
            strokeWidth = 5f
            isAntiAlias = false
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        path.reset()
        paint.color = Color.RED
        path.apply {
            moveTo(start.x, start.y)
            cubicTo(controll1.x, controll1.y, controll2.x, controll2.y, end.x, end.y)
            close()
        }
        canvas?.apply {
            drawPath(path, paint)
            paint.color = Color.BLUE
            drawCircle(controll1.x, controll1.y, 50f, paint)
            drawCircle(controll2.x, controll2.y, 50f, paint)
        }

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.apply {
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    isDraging1 = abs(x - lastX1) < 50 && abs(y - lastY1) < 50
                    isDraging2 = abs(x - lastX2) < 50 && abs(y - lastY2) < 50
                }
                MotionEvent.ACTION_MOVE -> {
                    if (isDraging1) {
                        controll1.x = x
                        controll1.y = y
                        lastX1 = x
                        lastY1 = y
                        invalidate()
                    }
                    if (isDraging2) {
                        controll2.x = x
                        controll2.y = y
                        lastX2 = x
                        lastY2 = y
                        invalidate()
                    }
                }
                MotionEvent.ACTION_UP -> {
                    isDraging1 = false
                    isDraging2 = false
                }
            }
        }
        return true
    }
}