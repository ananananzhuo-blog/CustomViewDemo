package com.mage.customviewdemo

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * author  :mayong
 * function:
 * date    :2021/6/6
 **/
class ArcToView : View {
    val path = Path()
    val paint = Paint()

    init {
        paint.color = Color.RED
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.apply {
            path.reset()
            paint.color=Color.YELLOW
            canvas.drawCircle(250f,250f,150f,paint)
            paint.color=Color.RED
            val ovalRectf = RectF(100f, 100f, 400f, 400f)
            path.arcTo(ovalRectf, 0f, 120f)
            path.close()
            drawPath(path, paint)
        }
    }
}