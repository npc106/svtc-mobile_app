package com.svtc.mobile.ui.screens

import androidx.compose.runtime.Composable
import com.svtc.mobile.data.NotificationItem
import com.svtc.mobile.data.UiState
import com.svtc.mobile.ui.components.BrandHeader
import com.svtc.mobile.ui.components.NotificationRow
import com.svtc.mobile.ui.components.ScreenList
import com.svtc.mobile.ui.components.StateContent

@Composable
fun NotificationsScreen(
    notificationsState: UiState<List<NotificationItem>>,
    onNotificationClick: (String?) -> Unit
) {
    StateContent(state = notificationsState) { notifications ->
        ScreenList {
            BrandHeader(
                title = "Thông báo",
                subtitle = "${notifications.count { it.unread }} chưa đọc"
            )
            notifications.forEach { item ->
                NotificationRow(item = item, onClick = onNotificationClick)
            }
        }
    }
}
