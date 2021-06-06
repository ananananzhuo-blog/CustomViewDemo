package com.mage.customviewdemo.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * author  :mayong
 * function:
 * date    :2021/6/6
 **/
class GradientView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    val paint = Paint()
    val path = Path()
    var shader: Shader? = null
        set(value) {
            field = value
            invalidate()
        }

    init {
        paint.color = Color.GREEN
        shader =
            LinearGradient(
                -300f,
                -300f,
                300f,
                300f,
                Color.WHITE,
                Color.RED,
                Shader.TileMode.CLAMP
            )
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        path.reset()
        canvas?.translate(measuredWidth / 2f, measuredHeight / 2f)
        paint.shader = shader
        path.addCircle(0f, 0f, 300f, Path.Direction.CW)
        canvas?.drawPath(path, paint)
    }

    fun setShaderText(s: String) {
        shader = when (s) {
            "LinearGradient" -> {
                LinearGradient(
                    -300f,
                    -300f,
                    300f,
                    300f,
                    Color.WHITE,
                    Color.RED,
                    Shader.TileMode.CLAMP
                )
            }
            "RadialGradient" -> {
                RadialGradient(0f,0f,200f,Color.YELLOW,Color.RED,Shader.TileMode.CLAMP)
            }
            "SweepGradient" -> {
                null
            }
            "BitmapShader" -> {
                null
            }
            "ComposeShader" -> {
                null
            }
            else ->
                null
        }
        invalidate()
    }
}