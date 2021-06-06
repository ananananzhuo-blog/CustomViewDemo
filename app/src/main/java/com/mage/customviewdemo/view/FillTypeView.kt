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
class FillTypeView : View {
    var paint = Paint()
    var path1 = Path()

    init {
        paint.color = Color.RED
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        path1.reset()
        canvas?.apply {
            path1.addCircle(200f, 200f, 100f, Path.Direction.CW)
            path1.addCircle(300f, 300f, 150f, Path.Direction.CCW)
            path1.fillType = Path.FillType.INVERSE_WINDING
            drawPath(path1, paint)
        }
    }
}