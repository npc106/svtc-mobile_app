package com.svtc.mobile.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.svtc.mobile.ui.components.BrandHeader
import com.svtc.mobile.ui.components.ScreenList

@Composable
fun AccountScreen(onLogout: () -> Unit) {
    var remindersEnabled by remember { mutableStateOf(true) }
    var generalEnabled by remember { mutableStateOf(true) }

    ScreenList {
        BrandHeader(title = "Tài khoản", subtitle = "Hồ sơ và hỗ trợ")
        ProfileBlock()
        SettingRow("Nhắc lịch học", remindersEnabled) { remindersEnabled = it }
        SettingRow("Thông báo chung", generalEnabled) { generalEnabled = it }
        SupportBlock()
        Button(
            onClick = onLogout,
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(vertical = 14.dp)
        ) {
            Text("Đăng xuất")
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
