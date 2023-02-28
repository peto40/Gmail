package com.example.gmail.ui.screens.compose_email

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gmail.R
import com.example.gmail.ui.component.ComposeTopBar
import com.example.gmail.ui.component.InputTextField
import com.example.gmail.ui.theme.GmailThemeColors
import com.example.gmail.ui.theme.GmailTypography

@Composable
fun ComposeEmailScreen(
    modifier: Modifier = Modifier,
    currentUserEmail: String = "petrosmalkhasyan13@gmail.com",
    navController: NavController,
) {

    val (toUser, setToUser) = remember { mutableStateOf("") }
    val (subject, setSubject) = remember { mutableStateOf("") }
    val (composeEmail, setComposeEmail) = remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(GmailThemeColors.surface)
    ) {
        ComposeTopBar(
            onBackClick = {
                navController.navigateUp()
            },
            onAttachFileClick = { },
            onSendClick = { },
            onSettingClick = { }
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                modifier = Modifier.padding(all = 6.dp),
                text = stringResource(id = R.string.lbl_from),
                style = GmailTypography.subtitle1,
                color = GmailThemeColors.onSurface
            )
            Text(
                modifier = Modifier.padding(all = 6.dp),
                text = currentUserEmail,
                style = GmailTypography.subtitle1,
                color = GmailThemeColors.onSurface
            )

            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = ""
                )
            }
        }

        InputTextField(
            hint = stringResource(id = R.string.lbl_to),
            textState = toUser,
            onValueChange = setToUser
        )

        InputTextField(
            hint = stringResource(id = R.string.lbl_subject),
            textState = subject,
            onValueChange = setSubject
        )

        InputTextField(
            hint = stringResource(id = R.string.lbl_compose_email),
            textState = composeEmail,
            onValueChange = setComposeEmail
        )

    }
}

