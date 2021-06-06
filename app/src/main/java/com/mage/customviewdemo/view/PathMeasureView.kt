package com.mage.customviewdemo.view.view

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * author  :mayong
 * function:PathMeasure 使用
 * date    :2021/6/6
 **/
class PathMeasureView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    val path = Path(
    )
    val paint = Paint()
    var startPos = 0f

    //    var  pathMeasure: PathMeasure = null
    lateinit var pathMeasure: PathMeasure

    init {
        paint.color = Color.RED
        paint.strokeWidth = 30f
        paint.isAntiAlias = false
        paint.style = Paint.Style.STROKE
        paint.strokeCap = Paint.Cap.ROUND
        path.moveTo(0f, 0f)
        path.lineTo(400f, 0f)
        path.lineTo(400f, 400f)
        path.lineTo(0f, 400f)
        path.close()
        pathMeasure = PathMeasure(path, true)

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val sizeWidth = MeasureSpec.getSize(widthMeasureSpec)
        val sizeHeight = MeasureSpec.getSize(heightMeasureSpec)
        setMeasuredDimension(sizeWidth, sizeHeight)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.translate(measuredWidth / 2f, measuredHeight / 2f)
        val dst = Path()
        path.apply {
            paint.color = Color.RED
            canvas?.drawPath(path, paint)
            pathMeasure.getSegment(startPos%pathMeasure.length,( startPos + pathMeasure.length * 0.1f)%pathMeasure.length, dst, true)
        }
        paint.color = Color.GREEN
        canvas?.drawPath(dst, paint)
    }

    fun startAnim() {
        val animator = ValueAnimator.ofFloat(0f, 1f)
        animator.duration = 5000
        animator.addUpdateListener { animinal ->
            startPos = animinal.animatedFraction * pathMeasure.length
            invalidate()
        }
        animator.start()
    }
}