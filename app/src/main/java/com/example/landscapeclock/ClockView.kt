package com.example.landscapeclock

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import androidx.core.content.res.ResourcesCompat
import java.util.*

class ClockView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val calendar = Calendar.getInstance()
    private var centerX = 0f
    private var centerY = 0f
    private var radius = 0f

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        centerX = w / 2f
        centerY = h / 2f
        radius = Math.min(w, h) / 2f * 0.9f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 更新当前时间
        calendar.time = Date()

        // 绘制表盘
        drawClockFace(canvas)

        // 绘制时针
        drawHourHand(canvas)

        // 绘制分针
        drawMinuteHand(canvas)

        // 绘制秒针
        drawSecondHand(canvas)

        // 绘制中心点
        drawCenterPoint(canvas)

        // 每秒重绘一次
        invalidate()
    }

    private fun drawClockFace(canvas: Canvas) {
        // 绘制表盘背景（黑底）
        paint.color = ResourcesCompat.getColor(resources, R.color.clockBackground, null)
        paint.style = Paint.Style.FILL
        canvas.drawCircle(centerX, centerY, radius, paint)

        // 只绘制简单的刻度线，不绘制数字和边框
        paint.color = ResourcesCompat.getColor(resources, R.color.clockText, null)
        paint.style = Paint.Style.STROKE

        // 绘制小时刻度（简化版）
        for (i in 1..12) {
            val angle = Math.PI / 6 * (i - 3)
            
            // 3、6、9、12位置的刻度线加粗
            paint.strokeWidth = if (i % 3 == 0) {
                radius * 0.025f  // 主刻度线更粗
            } else {
                radius * 0.015f  // 普通刻度线
            }
            
            val startX = centerX + Math.cos(angle).toFloat() * (radius * 0.9f)
            val startY = centerY + Math.sin(angle).toFloat() * (radius * 0.9f)
            val endX = centerX + Math.cos(angle).toFloat() * radius
            val endY = centerY + Math.sin(angle).toFloat() * radius
            canvas.drawLine(startX, startY, endX, endY, paint)
        }

        // 绘制分钟刻度（简化版）
        paint.strokeWidth = radius * 0.008f
        for (i in 1..60) {
            if (i % 5 != 0) {
                val angle = Math.PI / 30 * (i - 15)
                val startX = centerX + Math.cos(angle).toFloat() * (radius * 0.93f)
                val startY = centerY + Math.sin(angle).toFloat() * (radius * 0.93f)
                val endX = centerX + Math.cos(angle).toFloat() * radius
                val endY = centerY + Math.sin(angle).toFloat() * radius
                canvas.drawLine(startX, startY, endX, endY, paint)
            }
        }
    }

    private fun drawHourHand(canvas: Canvas) {
        val hour = calendar.get(Calendar.HOUR)
        val minute = calendar.get(Calendar.MINUTE)
        val angle = Math.PI / 6 * (hour + minute / 60.0 - 3)

        paint.color = ResourcesCompat.getColor(resources, R.color.clockHourHand, null)
        paint.style = Paint.Style.FILL
        paint.strokeWidth = radius * 0.05f

        val handLength = radius * 0.55f
        val x = centerX + Math.cos(angle).toFloat() * handLength
        val y = centerY + Math.sin(angle).toFloat() * handLength

        canvas.drawLine(centerX, centerY, x, y, paint)
    }

    private fun drawMinuteHand(canvas: Canvas) {
        val minute = calendar.get(Calendar.MINUTE)
        val second = calendar.get(Calendar.SECOND)
        val angle = Math.PI / 30 * (minute + second / 60.0 - 15)

        paint.color = ResourcesCompat.getColor(resources, R.color.clockMinuteHand, null)
        paint.style = Paint.Style.FILL
        paint.strokeWidth = radius * 0.03f

        val handLength = radius * 0.75f
        val x = centerX + Math.cos(angle).toFloat() * handLength
        val y = centerY + Math.sin(angle).toFloat() * handLength

        canvas.drawLine(centerX, centerY, x, y, paint)
    }

    private fun drawSecondHand(canvas: Canvas) {
        val second = calendar.get(Calendar.SECOND)
        val angle = Math.PI / 30 * (second - 15)

        paint.color = ResourcesCompat.getColor(resources, R.color.clockSecondHand, null)
        paint.style = Paint.Style.FILL
        paint.strokeWidth = radius * 0.015f

        val handLength = radius * 0.85f
        val x = centerX + Math.cos(angle).toFloat() * handLength
        val y = centerY + Math.sin(angle).toFloat() * handLength

        canvas.drawLine(centerX, centerY, x, y, paint)
    }

    private fun drawCenterPoint(canvas: Canvas) {
        // 中心点外圈
        paint.color = resources.getColor(R.color.clockSecondHand, null)
        paint.style = Paint.Style.FILL
        canvas.drawCircle(centerX, centerY, radius * 0.05f, paint)

        // 中心点内圈
        paint.color = ResourcesCompat.getColor(resources, R.color.clockBackground, null)
        canvas.drawCircle(centerX, centerY, radius * 0.03f, paint)
    }
}
