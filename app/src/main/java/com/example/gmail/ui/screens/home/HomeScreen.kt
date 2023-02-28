package com.example.gmail.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.gmail.model.emailList
import com.example.gmail.ui.component.EmailView
import com.example.gmail.ui.component.HomeTopBar
import com.example.gmail.ui.component.ProfileDialog


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onOpenDrawer: () -> Unit,
    lazyListState: LazyListState
) {
    var profileDialogState by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn(state = lazyListState) {
            item {
                HomeTopBar(
                    onOpenDrawer = onOpenDrawer,
                    onSearchButtonClick = { },
                    onProfileClick = { profileDialogState = profileDialogState.not() }
                )
                if (profileDialogState) {
                    ProfileDialog(
                        onDismiss = {
                            profileDialogState = !profileDialogState
                        }
                    )
                }
            }

            items(count = emailList.size) { index ->
                EmailView(email = emailList[index])
            }
        }
    }
}