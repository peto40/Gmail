package com.example.gmail.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.gmail.R
import com.example.gmail.ui.theme.GmailThemeColors
import com.example.gmail.ui.theme.GmailTypography

@Composable
fun ComposeEmailFab(
    modifier: Modifier = Modifier,
    extended: Boolean,
    onClick: () -> Unit,
) {
    FloatingActionButton(
        modifier = Modifier,
        shape = RoundedCornerShape(12.dp),
        onClick = onClick,
    ) {
        Row(
            modifier = modifier.background(GmailThemeColors.secondary),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.padding(all = 8.dp),
                imageVector = Icons.Default.Edit,
                tint = GmailThemeColors.onSurface,
                contentDescription = ""
            )

            AnimatedVisibility(visible = extended) {
                Row {
                    Spacer(Modifier.width(6.dp))
                    Text(
                        modifier = Modifier.padding(end = 8.dp),
                        text = stringResource(id = R.string.compose),
                        color = GmailThemeColors.onSurface,
                        style = GmailTypography.subtitle2
                    )
                }
            }

        }

    }
}