package com.svtc.mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.svtc.mobile.ui.SVTCApp
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
