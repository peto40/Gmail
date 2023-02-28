package com.example.gmail.ui.component.base_navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BaseNavigationRoute(
    var title: String = "",
    var icon: ImageVector = Icons.Default.Email,
    var screen_route: String,
) {
    object SignIn : BaseNavigationRoute(screen_route = "sign_in")

    object Home : BaseNavigationRoute("Home", icon = Icons.Default.Email, "home")

    object Meeting : BaseNavigationRoute("Meeting", icon = Icons.Default.Call, "meeting")

    object ComposeEmail : BaseNavigationRoute(screen_route = "compose_email")

}

