@echo off
set ANDROID_HOME=D:\android
set ANDROID_SDK_ROOT=D:\android
set PATH=%ANDROID_HOME%\cmdline-tools\latest\bin;%ANDROID_HOME%\platform-tools;%PATH%

echo Copying license files to Android SDK directory...
mkdir "%ANDROID_HOME%\licenses" 2>nul
copy "%~dp0licenses\*" "%ANDROID_HOME%\licenses\" /y

echo Building Android project...
gradle assembleDebug

if %ERRORLEVEL% EQU 0 (
    echo Build successful!
    echo APK location: app\build\outputs\apk\debug\app-debug.apk
) else (
    echo Build failed!
)

pause