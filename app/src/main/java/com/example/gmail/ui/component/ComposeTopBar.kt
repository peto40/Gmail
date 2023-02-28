package com.example.gmail.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.gmail.R
import com.example.gmail.ui.theme.GmailThemeColors
import com.example.gmail.ui.theme.GmailTypography

@Composable
fun ComposeTopBar(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onAttachFileClick: () -> Unit,
    onSendClick: () -> Unit,
    onSettingClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(GmailThemeColors.surface),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "",
                    tint = GmailThemeColors.onSurface
                )
            }
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = stringResource(id = R.string.compose),
                style = GmailTypography.h6,
                color = GmailThemeColors.onSurface
            )
        }

        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onAttachFileClick) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = "",
                    tint = GmailThemeColors.onSurface
                )
            }
            Spacer(modifier = Modifier.width(8.dp))

            IconButton(onClick = onSendClick) {
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = "",
                    tint = GmailThemeColors.onSurface
                )
            }
            Spacer(modifier = Modifier.width(8.dp))

            IconButton(onClick = onSettingClick) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "",
                    tint = GmailThemeColors.onSurface
                )
            }
        }
    }
}
