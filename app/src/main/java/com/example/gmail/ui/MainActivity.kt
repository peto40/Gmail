package com.example.gmail.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.gmail.ui.screens.base.Base
import com.example.gmail.ui.theme.GmailTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberScaffoldState()
            val navController = rememberNavController()
            val scope = rememberCoroutineScope()

            GmailTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.onSurface
                ) {
                    Base(
                        scaffoldState = scaffoldState,
                        navController = navController,
                        onOpenDrawer = {
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        },
                        onAllInboxesClick = { },
                        onSettingsClick = { },
                        onSentClick = { }
                    ) {

                    }
                }
            }
        }
    }
}