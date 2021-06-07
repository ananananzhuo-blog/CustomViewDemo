package com.mage.customviewdemo.view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.mage.customviewdemo.R

/**
 * author  :mayong
 * function:
 * date    :2021/6/7
 **/
class DrawBitmapView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private var bitmap: Bitmap=BitmapFactory.decodeResource(resources, R.mipmap.apple)
    private val paint = Paint().apply {

    }

    init {
//        bitmap = BitmapFactory.decodeResource(resources, R.mipmap.apple)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawBitmap(bitmap, 300f, 300f, paint)
    }
}