package com.svtc.mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Badge
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.svtc.mobile.ui.theme.SVTCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SVTCTheme {
                SVTCApp()
            }
        }
    }
}

private enum class MainTab(val label: String, val icon: String) {
    Home("Trang chủ", "⌂"),
    Schedule("Lịch học", "□"),
    Notifications("Thông báo", "●"),
    Account("Tài khoản", "◔")
}

private data class SessionItem(
    val title: String,
    val className: String,
    val time: String,
    val place: String,
    val status: String
)

private val sampleSessions = listOf(
    SessionItem(
        title = "Kỹ năng giao tiếp buổi 05",
        className = "SVTC-KNGT-01",
        time = "Thứ 2, 08:00 - 10:00",
        place = "Phòng A2, Cơ sở SVTC",
        status = "Sắp học"
    ),
    SessionItem(
        title = "Tin học ứng dụng buổi 03",
        className = "SVTC-THUD-02",
        time = "Thứ 4, 19:00 - 21:00",
        place = "Google Meet",
        status = "Online"
    ),
    SessionItem(
        title = "Kỹ năng phỏng vấn",
        className = "SVTC-KNPV-01",
        time = "Thứ 6, 18:30 - 20:30",
        place = "Phòng B1, Cơ sở SVTC",
        status = "Đổi lịch"
    )
)

@Composable
private fun SVTCApp() {
    var selectedTab by remember { mutableStateOf(MainTab.Home) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                MainTab.entries.forEach { tab ->
                    NavigationBarItem(
                        selected = selectedTab == tab,
                        onClick = { selectedTab = tab },
                        icon = { Text(tab.icon, style = MaterialTheme.typography.titleMedium) },
                        label = { Text(tab.label, maxLines = 1, overflow = TextOverflow.Ellipsis) }
                    )
                }
            }
        }
    ) { padding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            color = MaterialTheme.colorScheme.background
        ) {
            when (selectedTab) {
                MainTab.Home -> HomeScreen()
                MainTab.Schedule -> ScheduleScreen()
                MainTab.Notifications -> NotificationsScreen()
                MainTab.Account -> AccountScreen()
            }
        }
    }
}

@Composable
private fun HomeScreen() {
    ScreenList {
        BrandHeader(title = "Xin chào, Học viên", subtitle = "SVTC")
        StatRow()
        SectionTitle("Buổi học gần nhất")
        SessionCard(sampleSessions.first(), showReason = false)
        SectionTitle("Lớp đang học")
        ClassCard("SVTC-KNGT-01", "Kỹ năng giao tiếp", "12 buổi • tại trung tâm")
        ClassCard("SVTC-THUD-02", "Tin học ứng dụng", "8 buổi • online")
    }
}

@Composable
private fun ScheduleScreen() {
    ScreenList {
        BrandHeader(title = "Lịch học", subtitle = "Tuần này")
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            AssistChip(onClick = {}, label = { Text("Hôm nay") })
            AssistChip(onClick = {}, label = { Text("Tất cả lớp") })
            AssistChip(onClick = {}, label = { Text("Tuần") })
        }
        sampleSessions.forEach { session ->
            SessionCard(session, showReason = session.status == "Đổi lịch")
        }
    }
}

@Composable
private fun NotificationsScreen() {
    ScreenList {
        BrandHeader(title = "Thông báo", subtitle = "3 chưa đọc")
        NotificationRow("Đổi lịch", "Kỹ năng phỏng vấn chuyển sang 18:30 thứ 6.", "Vừa xong")
        NotificationRow("Nhắc lịch", "Kỹ năng giao tiếp bắt đầu sau 24 giờ.", "Hôm qua")
        NotificationRow("Thông báo lớp", "Vui lòng mang tài liệu buổi 05.", "20/06")
    }
}

@Composable
private fun AccountScreen() {
    var remindersEnabled by remember { mutableStateOf(true) }
    var generalEnabled by remember { mutableStateOf(true) }

    ScreenList {
        BrandHeader(title = "Tài khoản", subtitle = "Hồ sơ và hỗ trợ")
        ProfileBlock()
        SettingRow("Nhắc lịch học", remindersEnabled) { remindersEnabled = it }
        SettingRow("Thông báo chung", generalEnabled) { generalEnabled = it }
        SupportBlock()
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(vertical = 14.dp)
        ) {
            Text("Đăng xuất")
        }
    }
}

@Composable
private fun ScreenList(content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        content = content,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    )
}

@Composable
private fun BrandHeader(title: String, subtitle: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(subtitle, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
            Text(title, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
        }
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.Center
        ) {
            Text("SV", color = MaterialTheme.colorScheme.onPrimary, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
private fun StatRow() {
    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        StatCard("Lớp", "2", Modifier.weight(1f))
        StatCard("Sắp học", "1", Modifier.weight(1f))
        StatCard("Chưa đọc", "3", Modifier.weight(1f))
    }
}

@Composable
private fun StatCard(label: String, value: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(value, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Text(label, style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Composable
private fun SectionTitle(text: String) {
    Text(text, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
}

@Composable
private fun SessionCard(session: SessionItem, showReason: Boolean) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(session.title, fontWeight = FontWeight.Bold)
                    Text(session.className, color = MaterialTheme.colorScheme.primary)
                }
                StatusBadge(session.status)
            }
            Text(session.time)
            Text(session.place, color = MaterialTheme.colorScheme.onSurfaceVariant)
            if (showReason) {
                Divider()
                Text("Lý do: Giảng viên có lịch công tác, buổi học đã được đổi giờ.")
            }
        }
    }
}

@Composable
private fun StatusBadge(status: String) {
    Badge(
        containerColor = when (status) {
            "Đổi lịch" -> MaterialTheme.colorScheme.secondaryContainer
            "Online" -> MaterialTheme.colorScheme.tertiary
            else -> MaterialTheme.colorScheme.primaryContainer
        }
    ) {
        Text(status, modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp))
    }
}

@Composable
private fun ClassCard(code: String, name: String, meta: String) {
    Card(shape = RoundedCornerShape(8.dp)) {
        Column(modifier = Modifier.padding(14.dp)) {
            Text(code, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
            Text(name, style = MaterialTheme.typography.titleMedium)
            Text(meta, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

@Composable
private fun NotificationRow(type: String, body: String, time: String) {
    Card(shape = RoundedCornerShape(8.dp)) {
        Row(modifier = Modifier.padding(14.dp), verticalAlignment = Alignment.Top) {
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
            )
            Spacer(Modifier.size(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(type, fontWeight = FontWeight.Bold)
                Text(body)
            }
            Text(time, style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Composable
private fun ProfileBlock() {
    Card(shape = RoundedCornerShape(8.dp)) {
        Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text("Nguyễn Văn A", fontWeight = FontWeight.Bold)
            Text("hocvien@example.com")
            Text("0900 000 000")
        }
    }
}

@Composable
private fun SettingRow(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Card(shape = RoundedCornerShape(8.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(label, modifier = Modifier.weight(1f), fontWeight = FontWeight.Medium)
            Switch(checked = checked, onCheckedChange = onCheckedChange)
        }
    }
}

@Composable
private fun SupportBlock() {
    Card(shape = RoundedCornerShape(8.dp)) {
        Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text("Hỗ trợ SVTC", fontWeight = FontWeight.Bold)
            Text("Hotline: đang cập nhật")
            Text("Email: support@svtc.example")
        }
    }
}
