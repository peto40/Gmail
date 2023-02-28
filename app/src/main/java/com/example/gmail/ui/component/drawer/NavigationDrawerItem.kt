package com.example.gmail.ui.component.drawer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.gmail.ui.theme.GmailThemeColors
import com.example.gmail.ui.theme.GmailTypography

@Composable
fun NavigationDrawerItem(
    modifier: Modifier,
    imageVector: ImageVector,
    contentDescription: String = "",
    iconColor: Color = GmailThemeColors.onSurface,
    text: String,
    textStyle: TextStyle = GmailTypography.subtitle1,
    textColor: Color = GmailThemeColors.onSurface,
    onClick: () -> Unit,

) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.clickable { onClick() }
    ) {
        Icon(
            modifier = Modifier.padding(start = 8.dp),
            imageVector = imageVector,
            contentDescription = contentDescription,
            tint = iconColor
        )
        Text(
            modifier = Modifier.padding(start = 24.dp),
            text = text,
            style = textStyle,
            color = textColor,
            fontWeight = FontWeight.Bold,
        )
    }
}