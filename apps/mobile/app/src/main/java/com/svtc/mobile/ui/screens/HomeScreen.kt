package com.svtc.mobile.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.svtc.mobile.data.DashboardData
import com.svtc.mobile.data.UiState
import com.svtc.mobile.ui.components.BrandHeader
import com.svtc.mobile.ui.components.ClassCard
import com.svtc.mobile.ui.components.ScreenList
import com.svtc.mobile.ui.components.SectionTitle
import com.svtc.mobile.ui.components.SessionCard
import com.svtc.mobile.ui.components.StateContent
import com.svtc.mobile.ui.components.StatCard

@Composable
fun HomeScreen(dashboardState: UiState<DashboardData>, onSessionClick: (String) -> Unit) {
    StateContent(state = dashboardState) { dashboard ->
        ScreenList {
            BrandHeader(title = "Xin chào, ${dashboard.studentName}", subtitle = "SVTC")
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                StatCard("Lớp", dashboard.classes.size.toString(), Modifier.weight(1f))
                StatCard("Sắp học", if (dashboard.upcomingSession == null) "0" else "1", Modifier.weight(1f))
                StatCard("Chưa đọc", dashboard.unreadNotifications.toString(), Modifier.weight(1f))
            }
            SectionTitle("Buổi học gần nhất")
            dashboard.upcomingSession?.let {
                SessionCard(it, onClick = onSessionClick, showReason = false)
            }
            SectionTitle("Lớp đang học")
            dashboard.classes.forEach { ClassCard(it) }
        }
    }
}
