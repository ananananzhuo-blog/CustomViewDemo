package com.mage.customviewdemo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Path.*
import android.util.AttributeSet
import android.view.View
import java.util.jar.Attributes

/**
 * author  :mayong
 * function:
 * date    :2021/6/6
 **/
class PathOpView : View {
    var radius1 = 100f
    var paint1 = Paint()
    var radius2 = 100f
    var paint2 = Paint()
    var path1 = Path()
    var path2 = Path()
    var ops: Op = Op.UNION
        set(value) {
            field = value
            invalidate()
        }

    init {
        paint1.color = Color.YELLOW
        paint2.color = Color.GREEN
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(
            MeasureSpec.getSize(widthMeasureSpec),
            (MeasureSpec.getSize(heightMeasureSpec) * 0.6).toInt()
        )
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        path1.reset()
        path2.reset()
        canvas?.apply {
            path1.addCircle(200f, 200f, radius1, Direction.CW)
            path2.addCircle(400f, 400f, radius2, Direction.CW)
            path1.op(path2, ops)
            canvas.drawPath(path1, paint1)
//            canvas.drawPath(path2, paint2)
        }
    }

    fun setRadius(progress: Float) {
        radius1 = 100 * progress
        radius2 = 100 * progress
        invalidate()
    }


}