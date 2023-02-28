package com.example.gmail.ui.screens.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.gmail.R
import com.example.gmail.ui.component.ComposeEmailFab
import com.example.gmail.ui.component.base_navigation.BaseNavigationRoute
import com.example.gmail.ui.component.base_navigation.BottomNavigation
import com.example.gmail.ui.component.base_navigation.BottomNavigationGraph
import com.example.gmail.ui.component.drawer.NavigationDrawer
import com.example.gmail.ui.component.drawer.NavigationDrawerItem
import com.example.gmail.ui.theme.GmailThemeColors
import com.example.gmail.ui.theme.GmailTypography
import com.example.gmail.ui.util.isScrollingUp
import kotlin.math.roundToInt

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

    val lazyListState = rememberLazyListState()

    showBottomBar = when (navBackStackEntry?.destination?.route) {
        BaseNavigationRoute.Home.screen_route -> true
        BaseNavigationRoute.Meeting.screen_route -> true
        else -> false
    }
    showFab = when (navBackStackEntry?.destination?.route) {
        BaseNavigationRoute.Home.screen_route -> true
        else -> false
    }

    val bottomBarHeight = 64.dp
    val bottomBarHeightPx = with(LocalDensity.current) { bottomBarHeight.roundToPx().toFloat() }
    val bottomBarOffsetHeightPx = remember { mutableStateOf(0f) }

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {

                val delta = available.y
                val newOffset = bottomBarOffsetHeightPx.value + delta
                bottomBarOffsetHeightPx.value = newOffset.coerceIn(-bottomBarHeightPx, 0f)

                return Offset.Zero
            }
        }
    }

    Scaffold(
        modifier = Modifier.nestedScroll(nestedScrollConnection),
        scaffoldState = scaffoldState,
        drawerShape = RectangleShape,
        drawerContent = {
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
        if (showFab) ComposeEmailFab(extended = lazyListState.isScrollingUp()) {
            navController.navigate(BaseNavigationRoute.ComposeEmail.screen_route)
        }


    }, bottomBar = {
        if (showBottomBar) BottomNavigation(
            navController = navController,
            modifier = Modifier
                .height(bottomBarHeight)
                .offset { IntOffset(x = 0, y = -bottomBarOffsetHeightPx.value.roundToInt())}
        )

    }) { innerPadding ->
        BottomNavigationGraph(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            onOpenDrawer = onOpenDrawer,
            lazyListState = lazyListState
        )
    }
}





