package com.example.gmail.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gmail.ui.theme.GmailThemeColors
import com.example.gmail.ui.theme.GmailTypography

@Composable
fun InputTextField(
    hint: String,
    modifier: Modifier = Modifier,
    textState: String,
    onValueChange: (String) -> Unit,
) {
    TextField(
        value = textState,
        onValueChange = onValueChange,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = GmailThemeColors.surface,
                textColor = GmailThemeColors.onSurface,
                disabledIndicatorColor = GmailThemeColors.onSurface,
                errorIndicatorColor = GmailThemeColors.onSurface,
                focusedIndicatorColor = GmailThemeColors.onSurface,
                focusedLabelColor = GmailThemeColors.onSurface,
                cursorColor = GmailThemeColors.onSurface,
                unfocusedIndicatorColor = GmailThemeColors.primary
        ),
        label = { Text(text = hint) },
        textStyle = GmailTypography.subtitle1,
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
            .padding(top = 12.dp),

    )
}
