package com.example.gmail.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.gmail.ui.theme.GmailThemeColors
import com.example.gmail.ui.theme.GmailTypography

@Composable
fun LoginTextField(
    value: String,
    placeholder: String,
    secureText: Boolean = false,
    enabled: Boolean = true,
    onValueChange: (String) -> Unit,
) {

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        enabled = enabled,
        placeholder = {
            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = placeholder,
                style = GmailTypography.subtitle2,
                color = GmailThemeColors.onSurface
            )
        },
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = GmailThemeColors.surface,
            textColor = GmailThemeColors.onSurface,
            disabledIndicatorColor = GmailThemeColors.onSurface,
            errorIndicatorColor = GmailThemeColors.onSurface,
            focusedIndicatorColor = GmailThemeColors.onSurface,
            unfocusedIndicatorColor = GmailThemeColors.onSurface,
            cursorColor = GmailThemeColors.onSurface,

            ),
        visualTransformation = if (secureText) PasswordVisualTransformation() else
            VisualTransformation.None,
        onValueChange = onValueChange
    )
}