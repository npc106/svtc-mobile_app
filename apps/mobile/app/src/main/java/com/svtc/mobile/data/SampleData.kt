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

data class DashboardData(
    val studentName: String,
    val upcomingSession: SessionItem?,
    val classes: List<ClassItem>,
    val unreadNotifications: Int
)

data class StudentProfile(
    val fullName: String,
    val email: String,
    val phone: String,
    val hotline: String,
    val supportEmail: String
)

sealed interface UiState<out T> {
    data object Loading : UiState<Nothing>
    data class Empty(val message: String) : UiState<Nothing>
    data class Error(val message: String) : UiState<Nothing>
    data class Success<T>(val data: T) : UiState<T>
}

interface StudentRepository {
    fun dashboard(): UiState<DashboardData>
    fun sessions(): UiState<List<SessionItem>>
    fun sessionDetail(sessionId: String): UiState<SessionItem>
    fun notifications(): UiState<List<NotificationItem>>
    fun profile(): UiState<StudentProfile>
}

class MockStudentRepository : StudentRepository {
    override fun dashboard(): UiState<DashboardData> = UiState.Success(
        DashboardData(
            studentName = sampleProfile.fullName,
            upcomingSession = sampleSessions.firstOrNull(),
            classes = sampleClasses,
            unreadNotifications = sampleNotifications.count { it.unread }
        )
    )

    override fun sessions(): UiState<List<SessionItem>> = sampleSessions.toListState("Chưa có lịch học.")

    override fun sessionDetail(sessionId: String): UiState<SessionItem> {
        val session = sampleSessions.firstOrNull { it.id == sessionId }
        return if (session == null) UiState.Error("Không tìm thấy buổi học.") else UiState.Success(session)
    }

    override fun notifications(): UiState<List<NotificationItem>> =
        sampleNotifications.toListState("Chưa có thông báo.")

    override fun profile(): UiState<StudentProfile> = UiState.Success(sampleProfile)
}

private fun <T> List<T>.toListState(emptyMessage: String): UiState<List<T>> =
    if (isEmpty()) UiState.Empty(emptyMessage) else UiState.Success(this)

private val sampleProfile = StudentProfile(
    fullName = "Nguyễn Văn A",
    email = "hocvien@example.com",
    phone = "0900 000 000",
    hotline = "đang cập nhật",
    supportEmail = "support@svtc.example"
)

private val sampleSessions = listOf(
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

private val sampleClasses = listOf(
    ClassItem("SVTC-KNGT-01", "Kỹ năng giao tiếp", "12 buổi - tại trung tâm"),
    ClassItem("SVTC-THUD-02", "Tin học ứng dụng", "8 buổi - online")
)

private val sampleNotifications = listOf(
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
