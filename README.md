# Landscape Clock

An Android landscape analog clock application with calendar integration, designed for horizontal screen display.

## Features
- **Analog Clock Display**: Beautiful landscape-oriented analog clock
- **Calendar Integration**: Built-in calendar functionality
- **Custom Clock Interface**: Customizable clock face with Roman numerals
- **Screen Always-On**: Keeps screen awake for continuous time display
- **Responsive Design**: Optimized for horizontal screen orientation
- **Enhanced Visuals**: Hour marks remain bright, second ticks dimmed for better readability

## Screenshots
*Screenshots to be added*

## Technical Stack
- **Language**: Kotlin
- **Platform**: Android SDK 33
- **Build Tool**: Gradle 8.4
- **UI**: Material Design, Custom Views
- **Min SDK**: 24 (Android 7.0+)
- **Target SDK**: 33

## Build and Run
```bash
# Build the project
./gradlew build

# Install debug version
./gradlew installDebug

# Or use Android Studio
# Open project in Android Studio and click Run
```

## Project Structure
```
app/
├── src/main/
│   ├── java/com/example/landscapeclock/
│   │   ├── MainActivity.kt          # Main activity with fullscreen setup
│   │   ├── ClockView.kt             # Custom analog clock view
│   │   └── CalendarView.kt          # Calendar component
│   ├── res/
│   │   ├── layout/
│   │   ├── drawable/
│   │   ├── values/
│   │   │   └── colors.xml           # Color definitions
│   │   └── xml/
│   └── AndroidManifest.xml
├── build.gradle.kts                   # App-level build configuration
└── ...
```

## Development Requirements
- **IDE**: Android Studio (latest version recommended)
- **JDK**: JDK 17 or higher
- **Android SDK**: API level 33
- **Git**: For version control

## Recent Updates (v1.0.3)
- ✅ Added screen always-on functionality
- ✅ Added Roman numerals at 12, 3, 6, 9 positions
- ✅ Reduced brightness of second tick marks
- ✅ Enhanced visual hierarchy

## Roadmap
- [ ] Add multiple clock themes
- [ ] Add world clock functionality
- [ ] Add alarm features
- [ ] Add weather integration
- [ ] Add more customization options

## Contributing
Contributions are welcome! Please feel free to submit a Pull Request.

## License
MIT License - see [LICENSE](LICENSE) file for details.

---
**[中文文档](README.zh-CN.md)** | English

## Download
*Download links to be added when available on app stores*