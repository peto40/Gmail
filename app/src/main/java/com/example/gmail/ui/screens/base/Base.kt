package com.example.gmail.ui.screens.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.gmail.R
import com.example.gmail.ui.component.ComposeEmailButton
import com.example.gmail.ui.component.base_navigation.BaseNavigationRoute
import com.example.gmail.ui.component.base_navigation.BottomNavigation
import com.example.gmail.ui.component.base_navigation.BottomNavigationGraph
import com.example.gmail.ui.component.drawer.NavigationDrawer
import com.example.gmail.ui.component.drawer.NavigationDrawerItem
import com.example.gmail.ui.theme.GmailThemeColors
import com.example.gmail.ui.theme.GmailTypography

@Composable
fun Base(
    scaffoldState: ScaffoldState,
    navController: NavHostController,
    onOpenDrawer: () -> Unit,
    onAllInboxesClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onSentClick: () -> Unit,
    onSpamClick: () -> Unit,
) {
    var showBottomBar by rememberSaveable { mutableStateOf(true) }
    var showFab by rememberSaveable { mutableStateOf(true) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    showBottomBar = when (navBackStackEntry?.destination?.route) {
        BaseNavigationRoute.Home.screen_route -> true
        BaseNavigationRoute.Meeting.screen_route -> true
        else -> false
    }
    showFab = when (navBackStackEntry?.destination?.route) {
        BaseNavigationRoute.Home.screen_route -> true
        else -> false
    }

    Scaffold(scaffoldState = scaffoldState, drawerShape = RectangleShape, drawerContent = {
        NavigationDrawer(header = {
            Column {
                Text(
                    modifier = Modifier.padding(all = 16.dp),
                    text = stringResource(id = R.string.app_name),
                    style = GmailTypography.h6,
                    color = GmailThemeColors.primaryVariant,
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(GmailThemeColors.onSecondary)
                ) { }
            }
        }, content = {
            NavigationDrawerItem(
                modifier = Modifier
                    .requiredHeight(45.dp)
                    .padding(5.dp),
                imageVector = Icons.Default.Phone,
                text = stringResource(id = R.string.lbl_all_inboxes),
                onClick = onAllInboxesClick
            )
            Spacer(modifier = Modifier.padding(8.dp))
            NavigationDrawerItem(
                modifier = Modifier
                    .requiredHeight(45.dp)
                    .padding(5.dp),
                imageVector = Icons.Default.Send,
                text = stringResource(id = R.string.lbl_sent),
                onClick = onSentClick
            )
            Spacer(modifier = Modifier.padding(8.dp))
            NavigationDrawerItem(
                modifier = Modifier
                    .requiredHeight(45.dp)
                    .padding(5.dp),
                imageVector = Icons.Default.Warning,
                text = stringResource(id = R.string.lbl_spam),
                onClick = onSpamClick
            )
            Spacer(modifier = Modifier.padding(8.dp))
            NavigationDrawerItem(
                modifier = Modifier
                    .requiredHeight(45.dp)
                    .padding(5.dp),
                imageVector = Icons.Default.Settings,
                text = stringResource(id = R.string.lbl_settings),
                onClick = onSettingsClick
            )
        })
    }, floatingActionButton = {
        if (showFab) ComposeEmailButton {
            navController.navigate(BaseNavigationRoute.ComposeEmail.screen_route)
        }


    }, bottomBar = {
        if (showBottomBar) BottomNavigation(navController = navController)

    }) { innerPadding ->
        BottomNavigationGraph(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            onOpenDrawer = onOpenDrawer
        )
    }
}
