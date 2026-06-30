# Tài liệu setup và công nghệ dự án SVTC Mobile App

## 1. Tổng quan repository

Repository hiện tại là monorepo cho MVP Mobile App SVTC.

```text
mobile-app-svtc/
├─ apps/
│  ├─ mobile/        Ứng dụng Android cho học viên
│  └─ admin/         Trang quản trị, chưa triển khai
├─ services/
│  └─ api/           Backend API, hiện mới có API contract
├─ docs/             Tài liệu yêu cầu, setup và tổng hợp
├─ infra/            Ghi chú hạ tầng, chưa triển khai chi tiết
├─ docker-compose.yml
├─ .env.example
└─ README.md
```

## 2. Trạng thái hiện tại

Đã có:

- Tài liệu yêu cầu MVP.
- Android project trong `apps/mobile`.
- Android app mock bằng Kotlin + Jetpack Compose.
- Gradle wrapper để build mobile.
- API contract nháp trong `services/api/openapi.yaml`.

Chưa có:

- Backend runtime thật.
- Trang admin thật.
- Database schema/migration.
- Google Login thật.
- Push notification thật.
- Kết nối mobile với API thật.

## 3. Setup mobile app

Vị trí source code:

```text
apps/mobile
```

Mở thư mục này bằng Android Studio nếu chỉ muốn chạy app Android.

### Công cụ cần cài

- Android Studio.
- Android SDK.
- Android Emulator hoặc thiết bị Android thật.
- JDK/JBR 17. Android Studio có sẵn JBR phù hợp.

### Ngôn ngữ và framework

- Ngôn ngữ: Kotlin.
- UI framework: Jetpack Compose.
- Design system: Material 3.
- Build system: Gradle.
- Android Gradle Plugin: `8.13.2`.
- Kotlin plugin: `2.0.21`.
- Gradle wrapper: `8.13`.

### Cấu hình Android

Trong `apps/mobile/app/build.gradle.kts`:

- `applicationId`: `com.svtc.mobile`
- `namespace`: `com.svtc.mobile`
- `minSdk`: `28`
- `targetSdk`: `36`
- `compileSdk`: `36`
- `versionName`: `0.1.0`
- `versionCode`: `1`

### Thư viện mobile đang dùng

- `androidx.activity:activity-compose:1.9.3`
- `androidx.compose:compose-bom:2024.12.01`
- `androidx.compose.material3:material3`
- `androidx.compose.ui:ui`
- `androidx.compose.ui:ui-tooling-preview`
- `androidx.core:core-ktx:1.15.0`
- `androidx.lifecycle:lifecycle-runtime-ktx:2.8.7`
- `junit:junit:4.13.2`
- `androidx.test.ext:junit:1.2.1`
- `androidx.test.espresso:espresso-core:3.6.1`
- `androidx.compose.ui:ui-test-junit4`

### Cách mở bằng Android Studio

1. Mở Android Studio.
2. Chọn **Open**.
3. Chọn thư mục:

```text
C:\Users\Hi\OneDrive\documents\mobile-app-svtc\apps\mobile
```

4. Chờ Gradle Sync hoàn tất.
5. Chọn emulator hoặc thiết bị Android.
6. Bấm **Run**.

### Cách build bằng command line

Chạy trong thư mục:

```text
apps/mobile
```

Lệnh build debug:

```powershell
.\gradlew.bat :app:assembleDebug
```

Lệnh lint:

```powershell
.\gradlew.bat :app:lintDebug
```

Nếu command line dùng sai Java version, dùng JBR đi kèm Android Studio. Android Studio thường tự xử lý phần này khi bấm Run.

### File không commit

Không commit:

- `apps/mobile/local.properties`
- `apps/mobile/.gradle/`
- `apps/mobile/.kotlin/`
- `apps/mobile/app/build/`
- APK/AAB build output.

Các file này là local/cache/build output.

## 4. Cấu trúc mobile hiện tại

```text
apps/mobile/app/src/main/java/com/svtc/mobile/
├─ MainActivity.kt
├─ data/
│  └─ SampleData.kt
└─ ui/
   ├─ SVTCApp.kt
   ├─ components/
   │  └─ AppComponents.kt
   ├─ screens/
   │  ├─ LoginScreen.kt
   │  ├─ HomeScreen.kt
   │  ├─ ScheduleScreen.kt
   │  ├─ NotificationsScreen.kt
   │  ├─ AccountScreen.kt
   │  └─ SessionDetailScreen.kt
   └─ theme/
      └─ Theme.kt
```

Mobile hiện có:

- `MainActivity`: entry point Android.
- `SVTCApp`: app shell và navigation mock.
- `LoginScreen`: màn đăng nhập mock.
- `HomeScreen`: trang chủ mock.
- `ScheduleScreen`: lịch học mock.
- `NotificationsScreen`: thông báo mock.
- `AccountScreen`: tài khoản/hồ sơ mock.
- `SessionDetailScreen`: chi tiết buổi học mock.
- `MockStudentRepository`: dữ liệu mẫu tạm thời.
- `UiState`: trạng thái `Loading`, `Empty`, `Error`, `Success`.

Mobile hiện chưa gọi API thật. Dữ liệu đang lấy từ `MockStudentRepository` để dễ thay bằng API client sau này.

## 5. Setup backend API

Vị trí source code:

```text
services/api
```

Backend chưa triển khai runtime. Hiện mới có:

```text
services/api/openapi.yaml
```

File này là API contract nháp cho mobile, gồm các nhóm endpoint:

- Authentication.
- Student profile.
- Dashboard.
- Classes.
- Sessions.
- Devices.
- Notifications.

### Công nghệ backend

Chưa chốt triển khai trong source code.

Theo tài liệu yêu cầu, backend có thể dùng:

- Node.js/NestJS hoặc framework backend phù hợp.
- JWT/session management.
- Push notification service, ví dụ Firebase Cloud Messaging.
- PostgreSQL sau khi phần database được xác nhận.

Hiện tại chưa tạo database, migration hoặc ORM.

## 6. Setup admin web

Vị trí source code:

```text
apps/admin
```

Trang admin chưa triển khai. Hiện mới có README mô tả phạm vi.

Theo tài liệu yêu cầu, admin web sẽ cần:

- Đăng nhập admin.
- Quản lý học viên.
- Import CSV.
- Quản lý khóa học.
- Quản lý lớp.
- Quản lý buổi học.
- Gửi thông báo.

Gợi ý công nghệ ban đầu:

- React hoặc Next.js.
- TypeScript.
- UI component library sẽ chọn sau.

## 7. Database

Hiện tại **chưa setup database**.

Theo yêu cầu MVP, sau này hệ thống cần database riêng cho:

- Admin.
- Student.
- Course.
- Class.
- Enrollment.
- Session.
- Notification.
- DeviceSession.

Nhưng ở thời điểm hiện tại chưa tạo:

- Database schema.
- Migration.
- Seed data.
- ORM config.
- Kết nối PostgreSQL.

## 8. Môi trường và biến cấu hình

File mẫu:

```text
.env.example
```

Nguyên tắc:

- Không commit `.env`.
- Không commit secret thật.
- Không commit tài khoản dịch vụ cá nhân.
- Secret thật chỉ đặt trong biến môi trường hoặc secret manager.

## 9. Cách kiểm tra hiện tại

Kiểm tra mobile build:

```powershell
cd apps/mobile
.\gradlew.bat :app:assembleDebug
```

Kiểm tra mobile lint:

```powershell
cd apps/mobile
.\gradlew.bat :app:lintDebug
```

Hiện tại build và lint đã chạy thành công. Lint còn cảnh báo về việc có version thư viện mới hơn, nhưng không có lỗi chặn build.

## 10. Task tiếp theo đề xuất

Chưa đụng database, task tiếp theo hợp lý là:

1. Tạo backend runtime skeleton không database.
2. Thêm health check endpoint.
3. Thêm mock endpoints theo `services/api/openapi.yaml`.
4. Cho mobile gọi thử API local thay cho `MockStudentRepository`.
5. Sau khi luồng mock ổn mới tính tới database.
