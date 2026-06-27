# Kế hoạch triển khai và kiểm thử trong 8 tuần

## 1. Nhóm công việc

### Ứng dụng Android

- Khởi tạo dự án Android bằng công nghệ đã chọn.
- Đăng nhập Google và quản lý phiên.
- Xây 7 màn hình mobile.
- Push notification, deep link và build APK/AAB cho Android.
- Unit test phần mobile và sửa lỗi UAT.

### Backend và trang quản trị

- Khởi tạo backend và database độc lập.
- Xây chức năng xác thực, phân quyền và API cho mobile.
- Xây dựng 6 trang quản trị thuộc phạm vi MVP.
- Xây chức năng nhập CSV và tự sinh lịch hàng tuần.
- Xử lý thông báo, deploy, backup và log.
- Integration test API và hỗ trợ UAT.

### Tích hợp, kiểm thử và bàn giao

- Chốt dữ liệu/API, review code và xử lý tích hợp.
- Kiểm thử luồng thật với trung tâm.
- Hoàn thiện README, build APK/AAB và kiểm tra repository GitHub bàn giao.

## 2. Kế hoạch từng tuần

| Tuần | Mobile | Backend/Admin | Kết quả cuối tuần |
|---|---|---|---|
| 1 | Cấu trúc app, navigation, theme | Cấu trúc backend, database, admin login | Chạy được mobile/backend/admin ở local và staging |
| 2 | Giao diện đăng nhập, secure storage | Student, Google token verification, JWT/session | Đăng nhập Google theo email active chạy end-to-end |
| 3 | Trang chủ, hồ sơ | Student CSV, Course, Class, Enrollment | Admin nhập học viên; học viên thấy đúng hồ sơ và lớp |
| 4 | Lịch danh sách ngày/tuần | Lịch tuần, tự sinh Session và quản lý từng buổi | Admin sinh lịch theo thời lượng; app xem được lịch |
| 5 | Chi tiết buổi, trạng thái đổi/hủy | Logic đổi/hủy và tạo notification | Luồng đổi/hủy hoàn chỉnh trên app và API |
| 6 | Danh sách thông báo, push, deep link | Dịch vụ push, gửi push, nhắc lịch 24 giờ/30 phút | Push mở đúng buổi học trên thiết bị Android |
| 7 | Hoàn thiện UI, lỗi mạng, test thiết bị | Tìm kiếm cơ bản, bảo mật, backup, log | Bản release candidate và kiểm thử nội bộ |
| 8 | UAT, sửa lỗi, kiểm tra build Android | UAT, sửa lỗi, hoàn thiện README và source | Link GitHub sẵn sàng bàn giao |

## 3. Mốc kiểm soát phạm vi

- Hết tuần 2: đăng nhập phải hoàn chỉnh. Nếu chậm, bỏ toàn bộ P1.
- Hết tuần 4: lịch phải chạy end-to-end. Không thêm màn hình mới sau mốc này.
- Hết tuần 6: push phải hoạt động ổn định trên Android.
- Tuần 7-8 chỉ sửa lỗi, hoàn thiện và chuẩn bị bàn giao; không thêm chức năng.

## 4. Thứ tự ưu tiên

### P0 - Phải hoàn thành

- Google login theo danh sách email active.
- Trang chủ, lịch, chi tiết buổi, thông báo và hồ sơ.
- Admin quản lý học viên, lớp, buổi và thông báo.
- Nhập học viên bằng CSV.
- Tạo khóa học và tự sinh lịch lặp theo tuần.
- Đổi/hủy lịch và push notification.
- Phân quyền đúng theo enrollment.
- Môi trường chạy thử, backup và theo dõi lỗi.

### P1 - Làm sau khi P0 được nghiệm thu (không bắt buộc)

Không cần hoàn thành toàn bộ P1. Nếu còn thời gian sau khi P0 đã ổn định, đội phát triển chọn một hoặc một số chức năng phù hợp để thực hiện.

- Lịch sử thay đổi cơ bản.
- Xuất CSV học viên và lịch.

### Các chức năng làm sau MVP (không bắt buộc)

Các chức năng dưới đây không dùng để nghiệm thu MVP. Đội phát triển chỉ thực hiện khi chức năng chính đã hoàn thành và có thời gian còn lại.

- Tích hợp dữ liệu với các hệ thống SVTC.
- Tài liệu, bài tập, điểm danh và học phí.
- Chat, video, phụ huynh, giảng viên.
- Dashboard/báo cáo nâng cao.
- Offline phức tạp và đồng bộ calendar.

## 5. Kiểm thử bắt buộc

### Đăng nhập và phân quyền

- Email active đăng nhập thành công.
- Email không tồn tại hoặc bị khóa không vào được.
- Google token sai/hết hạn bị từ chối.
- Google subject ID không khớp với tài khoản đã liên kết bị từ chối.
- Admin xóa liên kết Google thì toàn bộ phiên cũ bị thu hồi.
- Học viên A không xem được lớp, buổi hoặc thông báo của B khi thay ID.
- Đăng xuất và khóa tài khoản thu hồi phiên đúng.
- Form admin thay đổi dữ liệu phải từ chối request thiếu hoặc sai token chống CSRF/biện pháp tương đương.

### Lịch

- Hiển thị đúng ngày, giờ theo múi giờ `Asia/Ho_Chi_Minh`.
- Sinh đúng số buổi từ ngày bắt đầu, lịch tuần và thời lượng khóa học.
- Chạy lại chức năng sinh lịch không tạo buổi trùng và không ghi đè buổi đã sửa thủ công.
- Buổi tại trung tâm hiển thị đúng địa chỉ/phòng; buổi online hiển thị đúng liên kết.
- Đổi một buổi không ảnh hưởng buổi khác.
- Hủy buổi vẫn hiển thị trạng thái và lý do.
- Lọc theo lớp và khoảng thời gian hoạt động đúng.

### Thông báo

- Đổi/hủy lịch gửi đúng học viên trong lớp.
- Danh sách người nhận thông báo phải giới hạn đúng các học viên có enrollment hợp lệ trong lớp.
- Bấm push mở đúng buổi ở trạng thái app đang mở, chạy nền và đã tắt.
- Nhắc lịch được gửi đúng ở mốc 24 giờ và 30 phút.
- Đổi lịch hủy nhắc cũ và tạo nhắc mới; hủy buổi xóa toàn bộ nhắc chưa gửi.
- Chạy lại tác vụ gửi không tạo thông báo trùng.
- Lỗi trên từng push token phải được cô lập, ghi nhận và không làm gián đoạn toàn bộ lượt gửi.

### Nhập CSV

- File UTF-8 đúng mẫu tạo được toàn bộ học viên hợp lệ.
- Email sai định dạng, email trùng và cột bắt buộc bị thiếu được báo đúng dòng.
- Dòng lỗi không làm dừng các dòng hợp lệ còn lại.
- Học viên mới nhập ở trạng thái `inactive` và chỉ đăng nhập được sau khi admin kích hoạt.

### Thiết bị

- Ít nhất hai thiết bị Android có kích thước và phiên bản hệ điều hành khác nhau.
- Kiểm tra mạng chậm, mất mạng, phiên hết hạn và server lỗi.

## 6. Tiêu chí nghiệm thu

- **UAT-01:** Admin tạo học viên; học viên đăng nhập đúng email Google.
- **UAT-01A:** Học viên nhập từ CSV không đăng nhập được trước khi kích hoạt và đăng nhập được sau khi admin kích hoạt.
- **UAT-02:** Admin tạo lớp, thêm học viên và tạo lịch; app hiển thị đúng.
- **UAT-02A:** Admin nhập CSV; dòng hợp lệ được tạo và dòng lỗi có thông báo rõ.
- **UAT-02B:** Admin khai báo thời lượng và lịch tuần; hệ thống sinh đúng các buổi và không tạo trùng.
- **UAT-03:** Admin đổi buổi; học viên nhận push và thấy thời gian cũ/mới cùng lý do.
- **UAT-04:** Admin hủy buổi; app hiển thị đã hủy và không nhắc lịch cũ.
- **UAT-05:** Học viên chỉ thấy dữ liệu các lớp của mình.
- **UAT-06:** Admin khóa học viên; phiên cũ không tiếp tục truy cập được.
- **UAT-07:** Các màn hình chính có trạng thái đang tải, rỗng và lỗi.
- **UAT-08:** Source code không chứa secret; môi trường chạy thử có backup và log lỗi.
- **UAT-09:** Có thể clone repository trên máy sạch và dựng hệ thống theo README mà không cần tài khoản hoặc file riêng của người phát triển.

## 7. Điều kiện để tiến độ 8 tuần khả thi

- SVTC chốt giao diện và quy trình trong tuần 1.
- Trong thời gian chờ logo và nội dung chính thức, đội phát triển dùng placeholder SVTC.
- Đội phát triển tự chuẩn bị các tài khoản, database, máy chủ và dịch vụ cần thiết bằng tài khoản cá nhân.
- SVTC có người nhập dữ liệu học viên/lớp/lịch và tham gia UAT.
- Không thay đổi phạm vi P0 sau tuần 2.

## 8. Phạm vi bàn giao

- Đường dẫn repository GitHub chứa source code ứng dụng Android, backend và trang admin.
- Quyền truy cập repository nếu dự án được đặt ở chế độ private.
- Quyền truy cập được giữ cho đến khi SVTC xác nhận đã clone repository thành công.
- Nhánh chính chứa phiên bản hoàn chỉnh đã nghiệm thu.
- README hướng dẫn cài đặt, cấu hình, chạy local, build APK/AAB và deploy backend.
- `.env.example` và danh sách biến môi trường, không chứa secret thật.
- Database schema, seed dữ liệu mẫu và tài liệu giao tiếp giữa các thành phần.
- Hướng dẫn cấu hình Google Authentication, dịch vụ push, database và máy chủ trên tài khoản mới.
- Hướng dẫn tạo admin đầu tiên, nhập CSV, tạo khóa học, sinh lịch và gửi thông báo.
- Danh sách chức năng dự kiến làm sau MVP và phương án kết nối với các hệ thống của SVTC.
- Tài khoản cá nhân, secret, database và máy chủ chạy thử không thuộc phạm vi bàn giao.
