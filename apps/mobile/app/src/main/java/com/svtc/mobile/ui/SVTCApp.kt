package com.svtc.mobile.ui

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import com.svtc.mobile.data.MockStudentRepository
import com.svtc.mobile.ui.components.MainBottomBar
import com.svtc.mobile.ui.screens.AccountScreen
import com.svtc.mobile.ui.screens.HomeScreen
import com.svtc.mobile.ui.screens.LoginScreen
import com.svtc.mobile.ui.screens.NotificationsScreen
import com.svtc.mobile.ui.screens.ScheduleScreen
import com.svtc.mobile.ui.screens.SessionDetailScreen

enum class MainTab(val label: String, val icon: String) {
    Home("Trang chủ", "⌂"),
    Schedule("Lịch học", "□"),
    Notifications("Thông báo", "●"),
    Account("Tài khoản", "◔")
}

private sealed interface AppRoute {
    data object Login : AppRoute
    data object Main : AppRoute
    data class SessionDetail(val sessionId: String) : AppRoute
}

@Composable
fun SVTCApp() {
    var route by remember { mutableStateOf<AppRoute>(AppRoute.Login) }
    var selectedTab by remember { mutableStateOf(MainTab.Home) }
    val repository = remember { MockStudentRepository() }

    when (val currentRoute = route) {
        AppRoute.Login -> LoginScreen(onLoginClick = { route = AppRoute.Main })
        AppRoute.Main -> {
            Scaffold(
                bottomBar = {
                    MainBottomBar(
                        selectedTab = selectedTab,
                        onTabSelected = { selectedTab = it }
                    )
                }
            ) { padding ->
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding),
                    color = MaterialTheme.colorScheme.background
                ) {
                    when (selectedTab) {
                        MainTab.Home -> HomeScreen(
                            dashboardState = repository.dashboard(),
                            onSessionClick = { route = AppRoute.SessionDetail(it) }
                        )
                        MainTab.Schedule -> ScheduleScreen(
                            sessionsState = repository.sessions(),
                            onSessionClick = { route = AppRoute.SessionDetail(it) }
                        )
                        MainTab.Notifications -> NotificationsScreen(
                            notificationsState = repository.notifications(),
                            onNotificationClick = { sessionId ->
                            route = sessionId?.let(AppRoute::SessionDetail) ?: AppRoute.Main
                        })
                        MainTab.Account -> AccountScreen(
                            profileState = repository.profile(),
                            onLogout = { route = AppRoute.Login }
                        )
                    }
                }
            }
        }
        is AppRoute.SessionDetail -> {
            SessionDetailScreen(
                sessionState = repository.sessionDetail(currentRoute.sessionId),
                onBack = { route = AppRoute.Main }
            )
        }
    }
}
