package com.example.gmail.ui.component.base_navigation

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.gmail.ui.screens.compose_email.ComposeEmailScreen
import com.example.gmail.ui.screens.home.HomeScreen
import com.example.gmail.ui.screens.login.SignInScreen
import com.example.gmail.ui.screens.meeting_screen.MeetingScreen


@Composable
fun BottomNavigationGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    lazyListState: LazyListState,
    onOpenDrawer: () -> Unit,
) {
    NavHost(navController, startDestination = BaseNavigationRoute.SignIn.screen_route) {

        composable(BaseNavigationRoute.SignIn.screen_route) {
            SignInScreen(navController = navController)
        }
        composable(route = BaseNavigationRoute.Home.screen_route) {
            HomeScreen(onOpenDrawer = onOpenDrawer, lazyListState = lazyListState)
        }
        composable(BaseNavigationRoute.Meeting.screen_route) {
            MeetingScreen()
        }
        composable(route = BaseNavigationRoute.ComposeEmail.screen_route) {
            ComposeEmailScreen(navController = navController)
        }
    }
}

