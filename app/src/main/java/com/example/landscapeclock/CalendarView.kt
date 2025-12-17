package com.example.landscapeclock

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.res.ResourcesCompat
import java.util.*

class CalendarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val calendar = Calendar.getInstance()
    private val today = Calendar.getInstance()
    private var width = 0f
    private var height = 0f
    private var cellSize = 0f

    // 星期标题数组
    private val weekDays = arrayOf(
        context.getString(R.string.week_sun),
        context.getString(R.string.week_mon),
        context.getString(R.string.week_tue),
        context.getString(R.string.week_wed),
        context.getString(R.string.week_thu),
        context.getString(R.string.week_fri),
        context.getString(R.string.week_sat)
    )

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        width = w.toFloat()
        height = h.toFloat()
        cellSize = Math.min(width, height) / 8f // 8行：1行标题 + 1行星期 + 6行日期
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 更新当前日期
        calendar.time = Date()
        today.time = Date()

        // 绘制月份标题
        drawMonthTitle(canvas)

        // 绘制星期标题
        drawWeekDays(canvas)

        // 绘制日期网格
        drawDateGrid(canvas)

        // 每天重绘一次
        invalidate()
    }

    private fun drawMonthTitle(canvas: Canvas) {
        paint.color = ResourcesCompat.getColor(resources, R.color.calendarHeader, null)
        paint.textSize = cellSize * 0.8f
        paint.textAlign = Paint.Align.CENTER
        paint.style = Paint.Style.FILL

        val month = calendar.get(Calendar.MONTH) + 1
        val year = calendar.get(Calendar.YEAR)
        val title = String.format("%d年%d月", year, month)

        canvas.drawText(title, width / 2f, cellSize * 0.7f, paint)
    }

    private fun drawWeekDays(canvas: Canvas) {
        paint.color = ResourcesCompat.getColor(resources, R.color.calendarText, null)
        paint.textSize = cellSize * 0.6f
        paint.textAlign = Paint.Align.CENTER
        paint.style = Paint.Style.FILL

        for (i in weekDays.indices) {
            val x = cellSize / 2f + i * cellSize
            val y = cellSize * 1.7f
            canvas.drawText(weekDays[i], x, y, paint)
        }
    }

    private fun drawDateGrid(canvas: Canvas) {
        // 保存当前月份和年份
        val currentMonth = calendar.get(Calendar.MONTH)
        val currentYear = calendar.get(Calendar.YEAR)

        // 设置为当月第一天
        calendar.set(Calendar.DAY_OF_MONTH, 1)

        // 获取当月第一天是星期几
        val firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1 // 0-6，0是周日

        // 获取当月天数
        val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

        // 绘制日期
        for (day in 1..daysInMonth) {
            val dayOfWeek = (firstDayOfWeek + day - 1) % 7
            val weekNumber = (firstDayOfWeek + day - 1) / 7

            val x = cellSize / 2f + dayOfWeek * cellSize
            val y = cellSize * (2.7f + weekNumber * 1f)

            // 检查是否是今天
            val isToday = (currentYear == today.get(Calendar.YEAR) &&
                    currentMonth == today.get(Calendar.MONTH) &&
                    day == today.get(Calendar.DAY_OF_MONTH))

            if (isToday) {
                // 绘制今天的背景
                paint.color = ResourcesCompat.getColor(resources, R.color.calendarCurrentDay, null)
                paint.style = Paint.Style.FILL
                canvas.drawCircle(x, y - cellSize * 0.2f, cellSize * 0.4f, paint)

                // 绘制今天的日期（白色）
                paint.color = ResourcesCompat.getColor(resources, R.color.calendarCurrentDayText, null)
                paint.textSize = cellSize * 0.6f
                paint.textAlign = Paint.Align.CENTER
            } else {
                // 绘制普通日期
                paint.color = resources.getColor(R.color.calendarText, null)
                paint.textSize = cellSize * 0.6f
                paint.textAlign = Paint.Align.CENTER
            }

            // 绘制日期数字
            canvas.drawText(day.toString(), x, y, paint)
        }

        // 恢复原始日期
        calendar.time = today.time
    }
}
