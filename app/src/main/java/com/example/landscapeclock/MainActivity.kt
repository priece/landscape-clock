package com.example.landscapeclock

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // UI组件已在布局文件中定义，无需额外初始化
        // ClockView和CalendarView会自动开始绘制
    }

    override fun onDestroy() {
        super.onDestroy()
        // 清理资源（如果有）
    }
}
