# 横屏时钟

一个Android横屏模拟时钟应用，集成日历功能，专为横屏显示设计。

## 功能特点
- **模拟时钟显示**: 精美的横屏模拟时钟界面
- **日历集成**: 内置日历功能
- **自定义时钟界面**: 可自定义的时钟表盘，带罗马数字
- **屏幕常亮**: 保持屏幕唤醒，持续显示时间
- **响应式设计**: 专为横屏方向优化
- **视觉增强**: 时刻度保持明亮，秒刻度降低亮度，提升可读性

## 截图展示
*截图待添加*

## 技术栈
- **编程语言**: Kotlin
- **开发平台**: Android SDK 33
- **构建工具**: Gradle 8.4
- **UI框架**: Material Design, 自定义视图
- **最低支持**: Android 7.0+ (API 24)
- **目标版本**: Android 13 (API 33)

## 构建和运行
```bash
# 构建项目
./gradlew build

# 安装调试版本
./gradlew installDebug

# 或使用Android Studio
# 在Android Studio中打开项目并点击运行
```

## 项目结构
```
app/
├── src/main/
│   ├── java/com/example/landscapeclock/
│   │   ├── MainActivity.kt          # 主活动，包含全屏设置
│   │   ├── ClockView.kt             # 自定义模拟时钟视图
│   │   └── CalendarView.kt          # 日历组件
│   ├── res/
│   │   ├── layout/
│   │   ├── drawable/
│   │   ├── values/
│   │   │   └── colors.xml           # 颜色定义
│   │   └── xml/
│   └── AndroidManifest.xml
├── build.gradle.kts                   # 应用级构建配置
└── ...
```

## 开发环境要求
- **IDE**: Android Studio (推荐使用最新版本)
- **JDK**: JDK 17或更高版本
- **Android SDK**: API级别33
- **Git**: 版本控制

## 最近更新 (v1.0.3)
- ✅ 添加屏幕常亮功能
- ✅ 在12、3、6、9位置添加罗马数字
- ✅ 降低秒刻度亮度，时刻度保持原样
- ✅ 增强视觉层次结构

## 开发路线图
- [ ] 添加多种时钟主题
- [ ] 添加世界时钟功能
- [ ] 添加闹钟功能
- [ ] 添加天气集成
- [ ] 添加更多自定义选项

## 贡献指南
欢迎贡献！请随时提交Pull Request。

## 许可证
MIT许可证 - 详见 [LICENSE](LICENSE) 文件

---
中文 | **[English](README.md)**

## 下载
*应用商店下载链接将在可用时添加*