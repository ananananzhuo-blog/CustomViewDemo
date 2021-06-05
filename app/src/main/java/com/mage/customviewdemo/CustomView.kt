package com.mage.customviewdemo

import android.content.Context
import android.graphics.Canvas
import android.graphics.PathMeasure
import android.util.AttributeSet
import android.view.View

/**
 * author  :mayong
 * function:
 * date    :2021/6/5
 **/
class CustomView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

}