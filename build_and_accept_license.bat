@echo off
set ANDROID_HOME=%~dp0android
set ANDROID_SDK_ROOT=%~dp0android
set ANDROID_LICENSES=%~dp0licenses
set PATH=%ANDROID_HOME%\cmdline-tools\latest\bin;%ANDROID_HOME%\platform-tools;%PATH%

echo Accepting Android SDK licenses...
echo y | sdkmanager --licenses

echo Licenses accepted. Now building the project...
gradle assembleDebug

if %ERRORLEVEL% EQU 0 (
    echo Build successful!
    echo APK location: app\build\outputs\apk\debug\app-debug.apk
) else (
    echo Build failed!
)

pause