package com.example.gmail.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gmail.ui.theme.GmailThemeColors

@Composable
fun HomeTopBar(
    onOpenDrawer: () -> Unit,
    onSearchButtonClick: () -> Unit,
    onProfileClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 12.dp)
            .background(
                color = GmailThemeColors.onSecondary,
                shape = RoundedCornerShape(24.dp)
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onOpenDrawer) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "",
                    tint = GmailThemeColors.onSurface
                )
            }
            IconButton(onClick = onSearchButtonClick) {
                Text(text = "Search in email")
            }
        }

        IconButton(
            onClick = onProfileClick
        ) {
            Icon(
                modifier = Modifier
                    .size(32.dp)
                    .padding(end = 3.dp),
                tint = GmailThemeColors.onSurface,
                imageVector = Icons.Default.AccountCircle,
                contentDescription = ""
            )
        }
    }
}