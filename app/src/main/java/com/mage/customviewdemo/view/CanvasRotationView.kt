package com.mage.customviewdemo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CanvasRotationView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    val paint = Paint().apply {
        color= Color.RED
        style=Paint.Style.STROKE
        isAntiAlias=true
    }
    init {

    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.save()//保存画布
        canvas?.translate(measuredWidth/2f,measuredHeight/2f)
        for (i in 0..360 step 60){
            canvas?.drawCircle(100f,0f,20f,paint)
            canvas?.rotate(60f)
        }
        canvas?.restore()//释放画布
        canvas?.drawCircle(100f,100f,100f,paint)

    }
}