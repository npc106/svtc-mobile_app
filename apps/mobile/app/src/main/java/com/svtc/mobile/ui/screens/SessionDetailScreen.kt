package com.svtc.mobile.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.svtc.mobile.data.SessionItem
import com.svtc.mobile.data.SessionStatus
import com.svtc.mobile.data.UiState
import com.svtc.mobile.ui.components.BrandHeader
import com.svtc.mobile.ui.components.ScreenList
import com.svtc.mobile.ui.components.SectionTitle
import com.svtc.mobile.ui.components.StateContent
import com.svtc.mobile.ui.components.StatusBadge

@Composable
fun SessionDetailScreen(sessionState: UiState<SessionItem>, onBack: () -> Unit) {
    StateContent(state = sessionState) { session ->
        ScreenList {
            BrandHeader(title = "Chi tiết buổi học", subtitle = "SVTC")
        Card(shape = RoundedCornerShape(8.dp)) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(session.title, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                Text(session.className, color = MaterialTheme.colorScheme.primary)
                StatusBadge(session.status)
            }
        }

        DetailBlock("Thời gian", session.time)
        session.previousTime?.let { DetailBlock("Thời gian cũ", it) }
        DetailBlock("Giảng viên", session.instructor)
        DetailBlock("Địa điểm", session.place)
        session.meetingUrl?.let { DetailBlock("Link online", it) }
        DetailBlock("Ghi chú", session.note)

        if (session.status == SessionStatus.Rescheduled || session.status == SessionStatus.Cancelled) {
            HorizontalDivider()
            DetailBlock("Lý do thay đổi", session.changeReason ?: "Đang cập nhật")
        }

        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(vertical = 14.dp)
        ) {
            Text("Quay lại")
        }
        }
    }
}

@Composable
private fun DetailBlock(label: String, value: String) {
    SectionTitle(label)
    Text(value, color = MaterialTheme.colorScheme.onSurfaceVariant)
}
