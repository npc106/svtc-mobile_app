# PRD - MVP Mobile App SVTC

## 1. Mục tiêu

Trong 8 tuần, đội phát triển xây dựng một ứng dụng Android giúp học viên đăng nhập, xem lịch học và nhận thông báo thay đổi lịch.

Kết quả cần đạt là một bản MVP có thể chạy thử với các lớp thật. Các chức năng quản lý đào tạo đầy đủ được đưa vào kế hoạch sau MVP.

## 2. Người dùng

| Vai trò | Phạm vi MVP |
|---|---|
| Học viên | Đăng nhập, xem lớp/lịch/buổi học/thông báo và hồ sơ cá nhân |
| Admin | Quản lý học viên, lớp, buổi học và thông báo |

Tài khoản giảng viên, phụ huynh và phân quyền admin nhiều cấp sẽ được xem xét sau MVP.

## 3. Quy trình sử dụng

1. Học viên đăng ký qua quy trình hiện có bên ngoài hệ thống MVP.
2. Nhân viên trung tâm đăng nhập admin, tạo và kích hoạt tài khoản học viên hoặc nhập danh sách bằng CSV.
3. Admin tạo khóa học, lớp, xếp học viên và thiết lập lịch học.
4. Học viên đăng nhập app bằng đúng tài khoản Google có email đã kích hoạt.
5. App đọc dữ liệu từ backend mobile độc lập.
6. Trong MVP, hệ thống dùng dữ liệu do admin nhập. Việc lấy dữ liệu từ các hệ thống khác của SVTC sẽ được thực hiện sau MVP.

## 4. Yêu cầu P0 bắt buộc

### AUTH - Đăng nhập

- **AUTH-01:** Đăng nhập bằng Google trên Android.
- **AUTH-02:** Backend xác minh Google ID token và `email_verified`.
- **AUTH-03:** Chỉ `Student` có email trùng và trạng thái `active` được vào app.
- **AUTH-04:** Email chưa kích hoạt nhận thông báo liên hệ trung tâm.
- **AUTH-05:** Có access token, refresh token, duy trì phiên và đăng xuất.
- **AUTH-06:** Khi admin khóa học viên, hệ thống phải thu hồi toàn bộ phiên đăng nhập còn hiệu lực.
- **AUTH-07:** Lần đăng nhập đầu tiên liên kết tài khoản học viên với Google subject ID (`sub`). Các lần sau phải kiểm tra đúng subject ID đã liên kết.
- **AUTH-08:** Admin có quyền xóa liên kết Google của học viên khi cần đổi tài khoản; thao tác này phải thu hồi toàn bộ phiên cũ.

### HOME - Trang chủ

- **HOME-01:** Hiển thị họ tên và buổi học gần nhất.
- **HOME-02:** Hiển thị các lớp đang học.
- **HOME-03:** Hiển thị số thông báo chưa đọc.
- **HOME-04:** Có trạng thái đang tải, không có dữ liệu và lỗi mạng.

### SCHEDULE - Lịch học

- **SCH-01:** Xem lịch dạng danh sách theo ngày/tuần.
- **SCH-02:** Chuyển tuần, quay lại hôm nay và lọc theo lớp.
- **SCH-03:** Mỗi buổi hiển thị tên, thời gian, giảng viên, địa điểm/online và trạng thái.
- **SCH-04:** Buổi đổi lịch hoặc hủy phải có nhãn rõ ràng.
- **SCH-05:** Mọi thời gian lưu theo UTC và hiển thị theo múi giờ `Asia/Ho_Chi_Minh`.
- **SCH-06:** Hỗ trợ buổi học tại trung tâm và buổi học online.
- **SCH-07:** Buổi học tại trung tâm hiển thị địa chỉ cơ sở và phòng học.
- **SCH-08:** Buổi học online hiển thị liên kết tham gia lớp.
- **SCH-09:** MVP quản lý một cơ sở; địa chỉ cơ sở được lưu trong cấu hình hệ thống.

### SESSION - Chi tiết buổi học

- **SES-01:** Hiển thị lớp, chủ đề, thời gian, giảng viên và ghi chú.
- **SES-02:** Hiển thị địa chỉ hoặc liên kết online.
- **SES-03:** Nếu đổi lịch, hiển thị thời gian cũ, thời gian mới và lý do.
- **SES-04:** Nếu hủy, vẫn giữ buổi trong lịch với trạng thái `cancelled`.

### NOTIFICATION - Thông báo

- **NOT-01:** Lưu push token theo học viên và thiết bị.
- **NOT-02:** Gửi ngay khi admin đổi hoặc hủy lịch.
- **NOT-03:** Gửi thông báo chung cho một lớp.
- **NOT-04:** Có danh sách, số chưa đọc và đánh dấu đã đọc.
- **NOT-05:** Bấm push mở đúng chi tiết buổi hoặc thông báo.
- **NOT-06:** Nhắc lịch tự động trước 24 giờ và 30 phút.
- **NOT-07:** Thông báo đổi/hủy lịch luôn được gửi; học viên có thể tắt thông báo nhắc lịch và thông báo chung.
- **NOT-08:** Đổi lịch phải hủy lịch nhắc cũ và tạo lại theo giờ mới; hủy buổi phải xóa các lịch nhắc chưa gửi.
- **NOT-09:** Mỗi sự kiện chỉ tạo một thông báo cho mỗi học viên/thiết bị, kể cả khi tác vụ được chạy lại.

### PROFILE - Hồ sơ

- **PRO-01:** Xem họ tên, email và số điện thoại.
- **PRO-02:** Xem hotline/email hỗ trợ.
- **PRO-03:** Bật/tắt thông báo chung; thông báo đổi/hủy lịch luôn bật.
- **PRO-04:** Đăng xuất.

### ADMIN - Quản trị vận hành MVP

- **ADM-01:** Admin đăng nhập bằng tài khoản riêng.
- **ADM-02:** Tạo, sửa, kích hoạt và khóa học viên theo email.
- **ADM-02A:** Nhập danh sách học viên bằng CSV; kiểm tra định dạng, email trùng và báo kết quả từng dòng. Tài khoản mới ở trạng thái `inactive`.
- **ADM-02B:** Cho phép admin kích hoạt từng học viên hoặc kích hoạt nhiều học viên sau khi kiểm tra dữ liệu CSV.
- **ADM-03:** Tạo, sửa lớp và thêm/bỏ học viên.
- **ADM-03A:** Tạo khóa học và lưu thời lượng theo số tuần.
- **ADM-04:** Tạo từng buổi hoặc tự sinh lịch từ ngày bắt đầu, thời lượng khóa học và các khung giờ lặp hàng tuần.
- **ADM-04A:** Cho phép sửa, đổi hoặc hủy riêng từng buổi đã sinh.
- **ADM-04B:** Khi sinh lại lịch, hệ thống phải giữ các buổi đã chỉnh thủ công và tránh tạo bản ghi trùng.
- **ADM-05:** Đổi/hủy buổi bắt buộc nhập lý do.
- **ADM-06:** Gửi thông báo cho một lớp.
- **ADM-07:** Danh sách phải tìm được theo tên hoặc email. Dashboard báo cáo được làm sau MVP.
- **ADM-08:** Trang admin phải yêu cầu đăng nhập, bảo vệ session và chống gửi form trái phép.

## 5. Chức năng P1 (không bắt buộc)

- Tìm kiếm/lọc lịch nâng cao.
- Lịch sử thay đổi buổi học ở mức cơ bản.
- Xuất danh sách học viên/lịch ra CSV.

Đội phát triển bắt đầu P1 sau khi đã kiểm thử đầy đủ các luồng P0 và được người phụ trách dự án xác nhận. Không cần hoàn thành toàn bộ P1; có thể chọn chức năng phù hợp với thời gian còn lại.

## 6. Các chức năng làm sau MVP (không bắt buộc)

Đây là danh sách mở rộng để tham khảo. Các chức năng này không thuộc tiêu chí nghiệm thu của MVP, trừ khi hai bên thống nhất bổ sung bằng văn bản. Ưu tiên của dự án vẫn là hoàn thành và ổn định các yêu cầu P0.

- Tích hợp dữ liệu với hệ thống SVTC.
- Tiếp nhận tự động hồ sơ đăng ký từ các hệ thống nguồn.
- Khóa học marketing, học phí, hóa đơn và thanh toán.
- Tài liệu, bài tập, điểm, điểm danh và chứng chỉ.
- Chat, video, thi online, phụ huynh và giảng viên.
- Quản lý nhiều cơ sở phức tạp.
- Phân quyền chi tiết và báo cáo nâng cao.

## 7. Mô hình dữ liệu tối thiểu

- `Admin`: tài khoản quản trị.
- `Student`: học viên và email được phép đăng nhập.
- `Course`: tên khóa học và thời lượng đào tạo.
- `Class`: lớp học thực tế.
- `Enrollment`: học viên thuộc lớp.
- `Session`: từng buổi học.
- `Notification`: thông báo trong app.
- `DeviceToken` hoặc `DeviceSession`: thiết bị, push token và refresh token.

Các mô hình `Assignment`, `Material`, `Attendance`, `Submission` được dành cho kế hoạch mở rộng chức năng đào tạo.

## 8. Yêu cầu phi chức năng tối thiểu

- API dùng HTTPS và phân quyền mọi tài nguyên theo học viên/enrollment.
- Token được lưu bằng Android Keystore hoặc secure storage tương đương; không lưu secret trong source code.
- App hỗ trợ tối thiểu Android 9+.
- Các API thông thường phản hồi dưới 1 giây trong điều kiện chạy thử.
- Có môi trường local và môi trường chạy thử tách biệt.
- Có backup database, log lỗi server và crash reporting mobile.
- Giao diện tiếng Việt và dùng tên thương hiệu SVTC.
- Dùng logo chữ SVTC dạng placeholder cho đến khi nhận bộ nhận diện chính thức.
- Logo, màu sắc, địa chỉ, danh sách phòng, nội dung liên hệ và nội dung pháp lý phải thay được từ asset/cấu hình mà không sửa logic ứng dụng.
- Hạ tầng phát triển/chạy thử dùng tài khoản cá nhân của đội phát triển; secret không được đưa vào source code.
- Có thể tham khảo nội dung và nhận diện công khai tại [https://svtc.edu.vn](https://svtc.edu.vn).
- Nội dung lấy từ website phải được SVTC xác nhận trước khi đưa vào bản bàn giao.

## 9. Tiêu chí thành công của MVP

- Một lớp thật có thể vận hành lịch hoàn toàn trên hệ thống mới.
- Học viên được kích hoạt đăng nhập và chỉ thấy dữ liệu lớp của mình.
- Admin đổi/hủy lịch; học viên nhận push và thấy dữ liệu cập nhật.
- Không có lỗi nghiêm trọng về đăng nhập, phân quyền hoặc sai lịch khi chạy thử.
- Admin có thể tạo khóa học, khai báo lịch tuần và tự sinh đúng số buổi trong thời lượng đã nhập.
- File CSV hợp lệ tạo được học viên; dòng lỗi được báo rõ và không làm dừng toàn bộ lần nhập.
