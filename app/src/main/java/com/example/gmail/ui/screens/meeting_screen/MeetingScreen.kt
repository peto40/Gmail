package com.example.gmail.ui.screens.meeting_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.gmail.ui.theme.GmailTypography

@Composable
fun MeetingScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Meeting screen",
            style = GmailTypography.h4
        )
    }
}