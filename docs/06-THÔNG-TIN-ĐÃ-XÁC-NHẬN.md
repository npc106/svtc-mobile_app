# Thông tin đã xác nhận

## 1. Nền tảng và bàn giao

- Ứng dụng phát triển cho Android.
- SVTC hiện có website; hệ thống mobile dùng backend và cơ sở dữ liệu riêng.
- Đội phát triển tự chọn công nghệ và tự tạo database, máy chủ, dịch vụ push cùng các dịch vụ cần thiết bằng tài khoản cá nhân trong thời gian phát triển/chạy thử.
- Bàn giao dự án bằng đường dẫn repository GitHub.
- Repository chứa toàn bộ source code và README hướng dẫn cài đặt, cấu hình, build, chạy và triển khai lại hệ thống.
- Nếu repository ở chế độ private, đội phát triển phải cấp quyền truy cập cho tài khoản GitHub do SVTC cung cấp.
- Quyền truy cập phải được giữ cho đến khi SVTC xác nhận đã clone repository thành công.
- Thông tin đăng nhập, secret và dữ liệu trên tài khoản cá nhân không đưa vào source code.

## 2. Học viên và đăng nhập

- Admin tạo tài khoản học viên bằng họ tên, email và thông tin cần thiết.
- Admin kích hoạt tài khoản trước khi học viên đăng nhập.
- Học viên đăng nhập bằng Google Authentication.
- Email Google phải trùng với email đã được admin kích hoạt.
- Admin có thể khóa tài khoản; hệ thống thu hồi phiên đăng nhập của tài khoản bị khóa.
- Trang admin hỗ trợ nhập danh sách học viên bằng file CSV.
- Học viên nhập từ CSV ở trạng thái chưa kích hoạt; admin kiểm tra và kích hoạt sau khi nhập.

## 3. Địa điểm và hình thức học

- SVTC có một cơ sở.
- Lớp học có hai hình thức: học tại trung tâm và học online.
- Địa chỉ cơ sở được cấu hình một lần trong trang quản trị hoặc biến cấu hình.
- Buổi học tại trung tâm hiển thị phòng học và địa chỉ.
- Buổi học online hiển thị liên kết tham gia lớp.

## 4. Khóa học và lịch học

- Admin có thể nhập từng buổi học.
- Admin có thể khai báo lịch lặp hàng tuần cho lớp.
- Khóa học lưu thời lượng theo số tuần.
- Khi tạo lớp, admin chọn khóa học, ngày bắt đầu và một hoặc nhiều khung giờ hàng tuần.
- Hệ thống tự sinh các buổi học từ ngày bắt đầu đến hết thời lượng khóa học.
- Admin có thể sửa, đổi hoặc hủy riêng từng buổi đã sinh.
- Việc sinh lại lịch phải tránh tạo trùng các buổi đã có.
- Hệ thống lưu thời gian theo UTC và hiển thị theo múi giờ `Asia/Ho_Chi_Minh`.

## 5. Thông báo

Đội phát triển tự chọn dịch vụ push notification cho Android. Chức năng thông báo phải tuân theo các quy tắc sau:

- Gửi ngay khi admin đổi hoặc hủy buổi học.
- Nhắc lịch trước 24 giờ và 30 phút.
- Admin có thể gửi thông báo chung cho một lớp.
- Thông báo đổi/hủy lịch luôn được gửi.
- Học viên có thể tắt thông báo nhắc lịch và thông báo chung.
- Bấm thông báo sẽ mở đúng buổi học hoặc nội dung liên quan.
- Khi buổi học bị đổi, lịch nhắc cũ được hủy và tạo lại theo giờ mới.
- Khi buổi học bị hủy, toàn bộ lịch nhắc chưa gửi của buổi đó được hủy.

## 6. Thương hiệu và nội dung

- Tên thương hiệu hiển thị: **SVTC**.
- Logo, màu sắc chi tiết, địa chỉ cơ sở, danh sách phòng, hotline, email hỗ trợ, chính sách riêng tư, điều khoản sử dụng và nội dung giới thiệu sẽ được SVTC cung cấp sau.
- Trong thời gian chờ, giao diện dùng placeholder có chữ SVTC.
- Logo, thông tin liên hệ và nội dung phải đặt trong file cấu hình hoặc thư mục asset riêng để thay thế mà không sửa logic ứng dụng.

## 7. Website tham khảo

- Website chính thức: [https://svtc.edu.vn](https://svtc.edu.vn).
- Đội phát triển có thể xem website để tham khảo tên thương hiệu, logo, giới thiệu trung tâm, danh sách khóa học, nội dung tuyển sinh, tin tức, địa chỉ, thông tin liên hệ và chính sách công khai.
- Website được dùng để tham khảo nội dung và nhận diện, không phải nguồn dữ liệu học viên hoặc lịch học của ứng dụng.
- Khi thông tin trên website khác với nội dung SVTC cung cấp trực tiếp, ưu tiên nội dung được SVTC xác nhận gần nhất.
- Trước khi bàn giao, đội phát triển phải gửi lại danh sách nội dung đã lấy từ website để SVTC kiểm tra.
