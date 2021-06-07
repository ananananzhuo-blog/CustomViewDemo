package com.mage.customviewdemo.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.mage.customviewdemo.R


/**
 * author    :  mayong
 * function  :  模糊效果
 * date      :  2021/6/6
 **/
class MaskFilterView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var maskFilter: BlurMaskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.SOLID)

    private val paint: Paint = Paint()
    var bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.mipmap.apple)

    init {
        paint.maskFilter = maskFilter
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.maskFilter=maskFilter
        var maskFilter: BlurMaskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.SOLID)
        canvas?.translate(measuredWidth / 2f, measuredHeight / 2f)
        canvas?.drawBitmap(bitmap, -200f, -200f, paint)
    }

    fun setMaskFilter(filter: String) {
        maskFilter = when (filter) {
            "NORMAL" -> {
                BlurMaskFilter(50f, BlurMaskFilter.Blur.NORMAL)
            }
            "OUTER" -> {
                BlurMaskFilter(50f, BlurMaskFilter.Blur.OUTER)
            }
            "INNER" -> {
                BlurMaskFilter(50f, BlurMaskFilter.Blur.INNER)
            }
            "SOLID" -> {
                BlurMaskFilter(50f, BlurMaskFilter.Blur.SOLID)
            }
            else -> {
                BlurMaskFilter(50f, BlurMaskFilter.Blur.NORMAL)
            }
        }
        invalidate()
    }

}