package com.example.gmail.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gmail.model.EmailModel
import com.example.gmail.ui.theme.GmailThemeColors
import com.example.gmail.ui.theme.GmailTypography

@Composable
fun EmailView(
    email: EmailModel
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .size(64.dp)
                .padding(all = 4.dp),
            imageVector = email.userImage,
            contentDescription = ""
        )

        Column(
            modifier = Modifier.padding(4.dp),

        ) {
            Text(
                text = email.userName,
                style = GmailTypography.subtitle1,
                color = GmailThemeColors.onSurface
            )
            Text(
                text = email.emailTitle,
                style = GmailTypography.subtitle2,
                color = GmailThemeColors.onSurface
            )
            Text(
                text = email.emailPreview,
                style = GmailTypography.subtitle2,
                color = GmailThemeColors.primary
            )
        }

    }
}