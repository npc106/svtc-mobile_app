package com.svtc.mobile.data

data class SessionItem(
    val id: String,
    val title: String,
    val className: String,
    val time: String,
    val previousTime: String? = null,
    val instructor: String,
    val place: String,
    val meetingUrl: String? = null,
    val note: String,
    val status: SessionStatus,
    val changeReason: String? = null
)

enum class SessionStatus(val label: String) {
    Upcoming("Sắp học"),
    Online("Online"),
    Rescheduled("Đổi lịch"),
    Cancelled("Đã hủy")
}

data class ClassItem(
    val code: String,
    val name: String,
    val meta: String
)

data class NotificationItem(
    val id: String,
    val type: String,
    val body: String,
    val time: String,
    val sessionId: String? = null,
    val unread: Boolean = true
)

val sampleSessions = listOf(
    SessionItem(
        id = "session-001",
        title = "Kỹ năng giao tiếp buổi 05",
        className = "SVTC-KNGT-01",
        time = "Thứ 2, 08:00 - 10:00",
        instructor = "Nguyễn Minh Anh",
        place = "Phòng A2, Cơ sở SVTC",
        note = "Mang theo tài liệu buổi trước.",
        status = SessionStatus.Upcoming
    ),
    SessionItem(
        id = "session-002",
        title = "Tin học ứng dụng buổi 03",
        className = "SVTC-THUD-02",
        time = "Thứ 4, 19:00 - 21:00",
        instructor = "Trần Quốc Bảo",
        place = "Google Meet",
        meetingUrl = "https://meet.google.com/svtc-demo",
        note = "Link học online sẽ mở trước giờ học 15 phút.",
        status = SessionStatus.Online
    ),
    SessionItem(
        id = "session-003",
        title = "Kỹ năng phỏng vấn",
        className = "SVTC-KNPV-01",
        time = "Thứ 6, 18:30 - 20:30",
        previousTime = "Thứ 6, 17:30 - 19:30",
        instructor = "Lê Hoàng Nam",
        place = "Phòng B1, Cơ sở SVTC",
        note = "Chuẩn bị CV cá nhân để thực hành.",
        status = SessionStatus.Rescheduled,
        changeReason = "Giảng viên có lịch công tác, buổi học đã được đổi giờ."
    )
)

val sampleClasses = listOf(
    ClassItem("SVTC-KNGT-01", "Kỹ năng giao tiếp", "12 buổi - tại trung tâm"),
    ClassItem("SVTC-THUD-02", "Tin học ứng dụng", "8 buổi - online")
)

val sampleNotifications = listOf(
    NotificationItem(
        id = "noti-001",
        type = "Đổi lịch",
        body = "Kỹ năng phỏng vấn chuyển sang 18:30 thứ 6.",
        time = "Vừa xong",
        sessionId = "session-003"
    ),
    NotificationItem(
        id = "noti-002",
        type = "Nhắc lịch",
        body = "Kỹ năng giao tiếp bắt đầu sau 24 giờ.",
        time = "Hôm qua",
        sessionId = "session-001"
    ),
    NotificationItem(
        id = "noti-003",
        type = "Thông báo lớp",
        body = "Vui lòng mang tài liệu buổi 05.",
        time = "20/06",
        sessionId = "session-001",
        unread = false
    )
)
