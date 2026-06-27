package com.svtc.mobile.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.svtc.mobile.data.SessionItem
import com.svtc.mobile.data.UiState
import com.svtc.mobile.ui.components.BrandHeader
import com.svtc.mobile.ui.components.ScreenList
import com.svtc.mobile.ui.components.SessionCard
import com.svtc.mobile.ui.components.StateContent

@Composable
fun ScheduleScreen(sessionsState: UiState<List<SessionItem>>, onSessionClick: (String) -> Unit) {
    StateContent(state = sessionsState) { sessions ->
        ScreenList {
            BrandHeader(title = "Lịch học", subtitle = "Tuần này")
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                AssistChip(onClick = {}, label = { Text("Hôm nay") })
                AssistChip(onClick = {}, label = { Text("Tất cả lớp") })
                AssistChip(onClick = {}, label = { Text("Tuần") })
            }
            sessions.forEach { session ->
                SessionCard(session, onClick = onSessionClick)
            }
        }
    }
}
