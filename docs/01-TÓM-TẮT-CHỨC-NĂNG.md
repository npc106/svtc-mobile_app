# Tóm tắt MVP Mobile App SVTC

## Điều kiện dự án

- Thời gian: 8 tuần.
- Nền tảng: Android.
- Sản phẩm bàn giao: đường dẫn GitHub chứa source code ứng dụng Android, backend, trang quản trị và README.
- Kiến trúc: backend và cơ sở dữ liệu riêng; việc kết nối với các hệ thống của SVTC sẽ thực hiện sau MVP.

## Chức năng học viên bắt buộc

### 1. Đăng nhập Google

- Admin tạo tài khoản và kích hoạt email học viên.
- Admin có thể nhập nhiều học viên bằng file CSV.
- Học viên đăng nhập bằng Google.
- Chỉ email đã kích hoạt mới được cấp quyền.
- Duy trì phiên đăng nhập và hỗ trợ đăng xuất.

### 2. Trang chủ

- Lời chào học viên.
- Buổi học sắp tới.
- Các lớp đang học.
- Số thông báo chưa đọc.

### 3. Lịch học

- Xem lịch theo danh sách ngày/tuần.
- Lọc theo lớp.
- Hệ thống quản lý một cơ sở SVTC.
- Buổi học hỗ trợ hình thức tại trung tâm hoặc online.
- Hiển thị giờ, tên buổi, giảng viên, địa điểm tại trung tâm hoặc liên kết online.
- Hiển thị rõ trạng thái bình thường, đổi lịch hoặc hủy.

### 4. Chi tiết buổi học

- Tên lớp và chủ đề.
- Thời gian bắt đầu/kết thúc.
- Giảng viên.
- Địa điểm hoặc liên kết học online.
- Ghi chú và lý do đổi/hủy lịch.

### 5. Thông báo

- Nhắc lịch trước 24 giờ và 30 phút.
- Thông báo đổi hoặc hủy lịch.
- Thông báo chung theo lớp.
- Danh sách đã đọc/chưa đọc.
- Bấm thông báo mở đúng buổi học.

### 6. Hồ sơ và hỗ trợ

- Xem họ tên, email, số điện thoại.
- Bật/tắt thông báo không khẩn cấp.
- Hotline, email và kênh hỗ trợ của trung tâm.
- Đăng xuất.

## Chức năng quản trị thuộc phạm vi MVP

- Đăng nhập admin.
- Tạo, sửa, kích hoạt và khóa học viên.
- Nhập danh sách học viên bằng CSV, kiểm tra lỗi và báo kết quả nhập.
- Tạo lớp và xếp học viên vào lớp.
- Tạo khóa học và khai báo thời lượng học.
- Tạo từng buổi học hoặc tự sinh buổi học theo lịch lặp hàng tuần.
- Sửa, đổi và hủy từng buổi đã sinh.
- Gửi thông báo theo lớp.
- Xem trạng thái gửi thông báo cơ bản.

## Các chức năng làm sau MVP (không bắt buộc)

Không cần thực hiện tất cả chức năng trong danh sách này. Đội phát triển tập trung hoàn thành các chức năng chính trước; nếu còn thời gian thì chọn một hoặc một số chức năng mở rộng phù hợp để thực hiện.

- Kết nối và đồng bộ dữ liệu với các hệ thống SVTC.
- Tài liệu học tập, bài tập, nộp bài và chấm điểm.
- Điểm danh.
- Thanh toán học phí.
- Chat, livestream, thi trực tuyến.
- Tài khoản phụ huynh hoặc app giảng viên.
- Đồng bộ Google Calendar.
- Chế độ offline nâng cao.
- Báo cáo, phân quyền và audit log phức tạp.

## Quyền lựa chọn công nghệ

Đội phát triển tự chọn công nghệ cho ứng dụng Android, backend, trang admin, database, push notification, hosting và theo dõi lỗi. Google Authentication là yêu cầu bắt buộc cho luồng đăng nhập học viên.

Công nghệ được chọn phải đáp ứng tiến độ, bảo mật, khả năng bảo trì và khả năng dựng lại hệ thống từ source code. README phải ghi rõ toàn bộ công nghệ, phiên bản, công cụ, dịch vụ, biến môi trường và các bước cài đặt.

Đội phát triển tự tạo và quản lý các tài khoản dịch vụ trong thời gian phát triển/chạy thử. Repository bàn giao không chứa tài khoản, secret hoặc dữ liệu trên hạ tầng cá nhân.

## Nguồn tham khảo

Đội phát triển có thể truy cập [https://svtc.edu.vn](https://svtc.edu.vn) để xem thông tin giới thiệu, thương hiệu, logo, khóa học, tuyển sinh, tin tức, liên hệ và chính sách công khai của SVTC. Nội dung sử dụng trong app phải được SVTC xác nhận trước khi bàn giao.
