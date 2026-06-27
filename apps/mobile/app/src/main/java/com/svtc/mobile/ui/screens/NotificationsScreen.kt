package com.svtc.mobile.ui.screens

import androidx.compose.runtime.Composable
import com.svtc.mobile.data.sampleNotifications
import com.svtc.mobile.ui.components.BrandHeader
import com.svtc.mobile.ui.components.NotificationRow
import com.svtc.mobile.ui.components.ScreenList

@Composable
fun NotificationsScreen(onNotificationClick: (String?) -> Unit) {
    ScreenList {
        BrandHeader(
            title = "Thông báo",
            subtitle = "${sampleNotifications.count { it.unread }} chưa đọc"
        )
        sampleNotifications.forEach { item ->
            NotificationRow(item = item, onClick = onNotificationClick)
        }
    }
}
