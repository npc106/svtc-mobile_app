# Tổng hợp thông tin MVP Mobile App SVTC

## 1. Mục tiêu dự án

Dự án xây dựng MVP ứng dụng Android cho học viên SVTC trong 8 tuần. Mục tiêu chính là giúp học viên đăng nhập bằng Google, xem lớp học, xem lịch học, nhận thông báo đổi/hủy lịch và nhắc lịch.

Hệ thống MVP gồm:

- Ứng dụng Android cho học viên.
- Trang quản trị cho nhân viên SVTC.
- Backend API riêng.
- Cơ sở dữ liệu riêng.
- Tích hợp push notification.
- README và tài liệu hướng dẫn dựng lại hệ thống.

MVP chưa kết nối trực tiếp với các hệ thống hiện có của SVTC. Phần đồng bộ dữ liệu sẽ được thực hiện sau MVP nếu có yêu cầu.

## 2. Phạm vi người dùng

### Học viên

Học viên dùng app Android để:

- Đăng nhập bằng Google.
- Xem trang chủ cá nhân.
- Xem lớp đang học.
- Xem lịch học theo ngày/tuần.
- Xem chi tiết buổi học.
- Nhận và xem thông báo.
- Xem hồ sơ, hỗ trợ và đăng xuất.

### Admin

Admin dùng trang quản trị để:

- Đăng nhập bằng tài khoản admin riêng.
- Quản lý học viên.
- Nhập danh sách học viên bằng CSV.
- Kích hoạt hoặc khóa tài khoản học viên.
- Tạo khóa học, lớp học và xếp học viên vào lớp.
- Nhập từng buổi học hoặc tự sinh lịch học theo lịch lặp hàng tuần.
- Sửa, đổi hoặc hủy từng buổi học.
- Gửi thông báo theo lớp.
- Xem trạng thái gửi thông báo cơ bản.

Giảng viên, phụ huynh, phân quyền admin nhiều cấp và các chức năng đào tạo đầy đủ chưa thuộc phạm vi MVP.

## 3. Chức năng học viên bắt buộc

### Đăng nhập

- Học viên đăng nhập bằng Google Authentication.
- Backend xác minh Google ID token, `email_verified`, `iss`, `aud`, `exp` và `sub`.
- Chỉ email đã được admin tạo và kích hoạt mới được vào app.
- Lần đăng nhập đầu liên kết tài khoản học viên với Google subject ID.
- Các lần sau phải kiểm tra đúng subject ID đã liên kết.
- Nếu admin khóa tài khoản hoặc xóa liên kết Google, toàn bộ phiên đăng nhập cũ phải bị thu hồi.
- App có access token, refresh token, duy trì phiên và đăng xuất.

### Trang chủ

- Hiển thị lời chào/họ tên học viên.
- Hiển thị buổi học gần nhất.
- Hiển thị các lớp đang học.
- Hiển thị số thông báo chưa đọc.
- Có trạng thái đang tải, không có dữ liệu và lỗi mạng.

### Lịch học

- Xem lịch dạng danh sách theo ngày/tuần.
- Chuyển tuần, quay lại hôm nay và lọc theo lớp.
- Mỗi buổi hiển thị tên, thời gian, giảng viên, địa điểm hoặc link online.
- Buổi học có trạng thái: bình thường, đổi lịch, hủy.
- Thời gian lưu theo UTC và hiển thị theo múi giờ `Asia/Ho_Chi_Minh`.
- MVP quản lý một cơ sở SVTC.

### Chi tiết buổi học

- Hiển thị lớp, chủ đề, thời gian, giảng viên, ghi chú.
- Buổi tại trung tâm hiển thị địa chỉ cơ sở và phòng học.
- Buổi online hiển thị liên kết tham gia.
- Nếu đổi lịch, hiển thị thời gian cũ, thời gian mới và lý do.
- Nếu hủy, vẫn giữ buổi trong lịch với trạng thái `cancelled`.

### Thông báo

- Lưu push token theo học viên và thiết bị.
- Gửi ngay khi admin đổi hoặc hủy lịch.
- Gửi thông báo chung theo lớp.
- Nhắc lịch tự động trước 24 giờ và 30 phút.
- Có danh sách thông báo, số chưa đọc và đánh dấu đã đọc.
- Bấm push mở đúng buổi học hoặc nội dung liên quan.
- Thông báo đổi/hủy lịch luôn được gửi.
- Học viên có thể tắt thông báo nhắc lịch và thông báo chung.
- Hệ thống phải tránh tạo/gửi thông báo trùng.

### Hồ sơ và hỗ trợ

- Xem họ tên, email, số điện thoại.
- Xem hotline/email hỗ trợ.
- Bật/tắt thông báo không khẩn cấp.
- Đăng xuất.

## 4. Màn hình mobile bắt buộc

MVP có 7 màn hình Android chính:

| Mã | Màn hình | Nội dung chính |
|---|---|---|
| M01 | Splash | Placeholder SVTC, kiểm tra phiên |
| M02 | Đăng nhập | Nút Google, điều khoản ngắn, lỗi email chưa kích hoạt |
| M03 | Trang chủ | Buổi gần nhất, lớp đang học, số thông báo chưa đọc |
| M04 | Lịch học | Danh sách ngày/tuần, lọc lớp, nhãn đổi/hủy |
| M05 | Chi tiết buổi | Thời gian, giảng viên, địa điểm/link, ghi chú, lý do |
| M06 | Thông báo | Danh sách, chưa đọc, mở đúng nội dung |
| M07 | Tài khoản | Hồ sơ, cài đặt thông báo, hỗ trợ, đăng xuất |

Bottom navigation gồm: Trang chủ, Lịch học, Thông báo, Tài khoản.

## 5. Trang admin trong MVP

| Mã | Trang | Nội dung chính |
|---|---|---|
| A01 | Đăng nhập admin | Email/mật khẩu và thông báo lỗi |
| A02 | Học viên | Danh sách, tạo, sửa, kích hoạt, khóa, nhập CSV, tìm kiếm |
| A03 | Khóa học | Tạo/sửa khóa học và thời lượng đào tạo |
| A04 | Lớp | Tạo/sửa lớp, hình thức học, lịch tuần, thêm/bỏ học viên |
| A05 | Buổi học | Tự sinh lịch, nhập từng buổi, sửa/đổi/hủy buổi |
| A06 | Thông báo | Soạn và gửi thông báo theo lớp, xem trạng thái cơ bản |

Trang admin phải có đăng nhập, bảo vệ session và chống gửi form trái phép bằng CSRF hoặc cơ chế tương đương.

## 6. Dữ liệu tối thiểu

Các mô hình dữ liệu chính:

- `Admin`: tài khoản quản trị.
- `SystemSetting`: tên thương hiệu, logo, địa chỉ, hotline, email hỗ trợ.
- `Student`: học viên, email, số điện thoại, trạng thái, Google subject ID.
- `Course`: khóa học, mã khóa, mô tả, thời lượng theo số tuần.
- `Class`: lớp học, khóa học, giảng viên, lịch tuần, hình thức học.
- `Enrollment`: học viên thuộc lớp.
- `Session`: từng buổi học, trạng thái, thời gian, lý do đổi/hủy.
- `Notification`: thông báo trong app và push.
- `NotificationRead`: trạng thái đã đọc.
- `DeviceSession`: thiết bị, push token, refresh token.

`Student`, `Class` và `Session` nên có `externalId` để chuẩn bị cho việc đồng bộ dữ liệu sau MVP. Không dùng email làm khóa chính.

## 7. API tham khảo cho mobile

Nếu chọn REST API, các nghiệp vụ tối thiểu gồm:

### Authentication

- `POST /api/v1/auth/google`
- `POST /api/v1/auth/refresh`
- `POST /api/v1/auth/logout`

### Học viên

- `GET /api/v1/me`
- `GET /api/v1/me/dashboard`
- `PATCH /api/v1/me/preferences`
- `PUT /api/v1/me/devices/:deviceId`

### Lớp và lịch

- `GET /api/v1/me/classes`
- `GET /api/v1/me/sessions?from=&to=&classId=`
- `GET /api/v1/me/sessions/:id`

### Thông báo

- `GET /api/v1/me/notifications?page=`
- `GET /api/v1/me/notifications/unread-count`
- `PATCH /api/v1/me/notifications/:id/read`

Mọi API phải kiểm tra quyền theo học viên và enrollment.

## 8. Quy tắc CSV

- File CSV dùng UTF-8 và có hàng tiêu đề.
- Cột bắt buộc: `fullName`, `email`.
- Cột tùy chọn: `phone`, `classCode`.
- Email được chuẩn hóa chữ thường và bỏ khoảng trắng thừa.
- Kiểm tra email sai định dạng, email trùng trong file và email đã tồn tại.
- Học viên mới nhập từ CSV ở trạng thái `inactive`.
- Dòng lỗi không làm dừng các dòng hợp lệ khác.
- Sau khi nhập, admin nhận tổng số dòng thành công, thất bại và lý do lỗi từng dòng.
- Admin kích hoạt từng học viên hoặc kích hoạt nhiều học viên sau khi kiểm tra.

## 9. Quy tắc sinh lịch

- Admin tạo khóa học và nhập thời lượng theo số tuần.
- Admin tạo lớp, chọn khóa học, ngày bắt đầu và một hoặc nhiều khung giờ lặp hàng tuần.
- Hệ thống sinh buổi học từ ngày bắt đầu đến hết thời lượng khóa học.
- `scheduleKey` gồm `classId + date + startTime` để tránh tạo trùng.
- Buổi đã chỉnh thủ công phải được giữ khi sinh lại lịch.
- Admin có thể thêm buổi riêng, đổi lịch hoặc hủy từng buổi.
- Đổi/hủy lịch sau khi lớp có học viên phải tạo thông báo.
- Đổi lịch phải hủy nhắc cũ và tạo nhắc mới.
- Hủy buổi phải xóa toàn bộ nhắc chưa gửi.

## 10. Bảo mật và phi chức năng

- API dùng HTTPS.
- Có versioning nếu dùng HTTP API.
- Access token ngắn hạn, refresh token lưu dạng hash.
- Token trên Android lưu bằng Keystore hoặc secure storage tương đương.
- Secret chỉ nằm trong biến môi trường, không đưa vào source code.
- Rate limit đăng nhập và validate toàn bộ request.
- Phân quyền mọi truy vấn lớp, buổi và thông báo theo enrollment.
- Mật khẩu admin phải được băm an toàn.
- Cookie/session admin có `HttpOnly`, `Secure` khi dùng HTTPS và `SameSite` phù hợp.
- App hỗ trợ tối thiểu Android 9+.
- API thông thường phản hồi dưới 1 giây trong điều kiện chạy thử.
- Có môi trường local và staging tách biệt.
- Có backup database, log lỗi server và crash reporting mobile.
- Giao diện tiếng Việt và dùng thương hiệu SVTC.

## 11. Kế hoạch 8 tuần

| Tuần | Trọng tâm | Kết quả |
|---|---|---|
| 1 | Cấu trúc mobile, backend, database, admin login | Chạy được local và staging |
| 2 | Google login, secure storage, xác minh token, JWT/session | Đăng nhập end-to-end theo email active |
| 3 | Trang chủ, hồ sơ, CSV, Course, Class, Enrollment | Admin nhập học viên; app thấy hồ sơ và lớp |
| 4 | Lịch ngày/tuần, lịch lặp, tự sinh Session | App xem được lịch đã sinh |
| 5 | Chi tiết buổi, đổi/hủy lịch, notification | Luồng đổi/hủy hoàn chỉnh |
| 6 | Push, deep link, nhắc lịch 24h/30p | Push mở đúng buổi trên Android |
| 7 | Hoàn thiện UI, lỗi mạng, bảo mật, backup, log | Release candidate |
| 8 | UAT, sửa lỗi, README, build APK/AAB | Repository GitHub sẵn sàng bàn giao |

Mốc kiểm soát:

- Hết tuần 2: đăng nhập phải hoàn chỉnh; nếu chậm thì bỏ toàn bộ P1.
- Hết tuần 4: lịch phải chạy end-to-end; không thêm màn hình mới sau mốc này.
- Hết tuần 6: push phải ổn định trên Android.
- Tuần 7-8 chỉ sửa lỗi, hoàn thiện và bàn giao.

## 12. Tiêu chí nghiệm thu chính

- Admin tạo học viên; học viên đăng nhập đúng email Google.
- Học viên nhập từ CSV không đăng nhập được trước khi kích hoạt và đăng nhập được sau khi kích hoạt.
- Admin tạo lớp, thêm học viên, tạo lịch; app hiển thị đúng.
- CSV hợp lệ tạo được học viên; dòng lỗi được báo rõ.
- Hệ thống sinh đúng các buổi theo thời lượng và không tạo trùng.
- Admin đổi buổi; học viên nhận push và thấy thời gian cũ/mới cùng lý do.
- Admin hủy buổi; app hiển thị đã hủy và không nhắc lịch cũ.
- Học viên chỉ thấy dữ liệu lớp của mình.
- Admin khóa học viên; phiên cũ không tiếp tục truy cập được.
- Các màn hình chính có trạng thái loading, rỗng và lỗi.
- Source code không chứa secret.
- Có thể clone repository trên máy sạch và dựng hệ thống theo README.

## 13. Phạm vi bàn giao

Bàn giao qua đường dẫn GitHub repository, gồm:

- Source code Android app.
- Source code backend.
- Source code trang admin.
- Database schema và seed dữ liệu mẫu.
- `.env.example`, không chứa secret thật.
- README hướng dẫn cài đặt, cấu hình, chạy local, build APK/AAB và deploy backend.
- Hướng dẫn cấu hình Google Authentication, push notification, database và máy chủ mới.
- Hướng dẫn tạo admin đầu tiên, nhập CSV, tạo khóa học, sinh lịch và gửi thông báo.
- Tài liệu API hoặc tài liệu giao tiếp dữ liệu.
- Danh sách chức năng dự kiến làm sau MVP.

Nếu repository private, đội phát triển phải cấp quyền cho tài khoản GitHub do SVTC cung cấp và giữ quyền truy cập đến khi SVTC xác nhận đã clone thành công.

Tài khoản cá nhân, secret, database chạy thử và máy chủ chạy thử không thuộc nội dung bàn giao.

## 14. Ngoài phạm vi MVP

Các phần sau không bắt buộc trong MVP:

- Đồng bộ dữ liệu với hệ thống SVTC.
- Tài liệu học tập, bài tập, nộp bài, chấm điểm.
- Điểm danh.
- Học phí, hóa đơn, thanh toán.
- Chat, livestream, video, thi online.
- App giảng viên hoặc tài khoản phụ huynh.
- Quản lý nhiều cơ sở phức tạp.
- Dashboard, báo cáo nâng cao, phân quyền chi tiết và audit log phức tạp.
- Offline nâng cao và đồng bộ Google Calendar.

## 15. Thông tin đã xác nhận

- Nền tảng: Android.
- Backend và database: độc lập với hệ thống hiện tại của SVTC.
- Thương hiệu hiển thị: SVTC.
- SVTC có một cơ sở trong phạm vi MVP.
- Hình thức học: tại trung tâm hoặc online.
- Thời gian lưu UTC, hiển thị `Asia/Ho_Chi_Minh`.
- Logo, màu sắc, địa chỉ, phòng học, hotline, email hỗ trợ, chính sách riêng tư và điều khoản sử dụng sẽ được SVTC cung cấp sau.
- Trong thời gian chờ, dùng placeholder SVTC.
- Website tham khảo: https://svtc.edu.vn.
- Nội dung lấy từ website phải được SVTC xác nhận trước khi bàn giao.
