# Landscape Clock - 横屏模拟时钟

一个Android横屏模拟时钟应用，支持横屏显示模拟时钟和日历。

## 功能特点
- 横屏显示模拟时钟
- 集成日历功能
- 自定义时钟界面
- 响应式设计

## 技术栈
- Kotlin
- Android SDK 33
- Gradle 8.4
- Material Design

## 构建和运行
```bash
./gradlew build
./gradlew installDebug
```

## 项目结构
```
app/
├── src/main/
│   ├── java/com/example/landscapeclock/
│   │   ├── MainActivity.kt
│   │   ├── ClockView.kt
│   │   └── CalendarView.kt
│   ├── res/
│   │   ├── layout/
│   │   ├── drawable/
│   │   ├── values/
│   │   └── xml/
│   └── AndroidManifest.xml
├── build.gradle.kts
└── ...
```

## 开发环境要求
- Android Studio
- JDK 17
- Android SDK 33

## 许可证
MIT License