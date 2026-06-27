# SVTC Mobile App

Android application for students, built with Kotlin and Jetpack Compose.

## MVP Scope

- Google sign-in.
- Home screen with upcoming lesson, enrolled classes, and unread notifications.
- Schedule list by day or week.
- Lesson detail screen.
- Notifications list and notification deep links.
- Student profile and support information.

## Notes

- Student login must use Google Authentication.
- Only activated student emails can access the app.
- Time should be displayed using `Asia/Ho_Chi_Minh`.
- Brand assets and SVTC contact information should be configurable.

## Setup

This folder now contains the initial Android project skeleton with mock data for the main MVP screens.

To open it:

1. Open Android Studio.
2. Choose **Open**.
3. Select the `apps/mobile` folder.
4. Wait for Gradle sync to finish.
5. Choose an emulator or Android device.
6. Press **Run**.

Do not commit `local.properties`. Android Studio creates it locally to point to the Android SDK path on each developer machine.

## Command Line

Use the checked-in Gradle wrapper from this folder:

```powershell
.\gradlew.bat :app:assembleDebug
.\gradlew.bat :app:lintDebug
```

If command-line builds use the wrong Java version, run them with the JBR bundled with Android Studio. Android Studio itself normally handles this automatically.
