package com.svtc.mobile.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.svtc.mobile.data.sampleClasses
import com.svtc.mobile.data.sampleNotifications
import com.svtc.mobile.data.sampleSessions
import com.svtc.mobile.ui.components.BrandHeader
import com.svtc.mobile.ui.components.ClassCard
import com.svtc.mobile.ui.components.ScreenList
import com.svtc.mobile.ui.components.SectionTitle
import com.svtc.mobile.ui.components.SessionCard
import com.svtc.mobile.ui.components.StatCard

@Composable
fun HomeScreen(onSessionClick: (String) -> Unit) {
    ScreenList {
        BrandHeader(title = "Xin chào, Học viên", subtitle = "SVTC")
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            StatCard("Lớp", sampleClasses.size.toString(), Modifier.weight(1f))
            StatCard("Sắp học", "1", Modifier.weight(1f))
            StatCard("Chưa đọc", sampleNotifications.count { it.unread }.toString(), Modifier.weight(1f))
        }
        SectionTitle("Buổi học gần nhất")
        SessionCard(sampleSessions.first(), onClick = onSessionClick, showReason = false)
        SectionTitle("Lớp đang học")
        sampleClasses.forEach { ClassCard(it) }
    }
}
