package com.example.gmail.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.gmail.R
import com.example.gmail.ui.theme.GmailThemeColors
import com.example.gmail.ui.theme.GmailTypography

@Composable
fun ProfileDialog(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
    ) {
    Dialog(
        onDismissRequest = onDismiss,
    ) {
        Card(
            modifier = modifier
                .padding(8.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            elevation = 6.dp
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(GmailThemeColors.onSecondary)
            ) {
                Text(
                    text = stringResource(id = R.string.lbl_google),
                    modifier = Modifier
                        .padding(8.dp)
                        .align(CenterHorizontally),
                    style = GmailTypography.h5,
                    color = GmailThemeColors.onSurface,
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier
                            .size(38.dp)
                            .padding(start = 4.dp),
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "",
                        tint = GmailThemeColors.onSurface
                    )
                    Spacer(modifier = Modifier.width(4.dp))

                    Column(
                        modifier = Modifier.padding(start = 4.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Petros Malkhasyan",
                            style = GmailTypography.subtitle2,
                            color = GmailThemeColors.onSurface
                        )

                        Text(
                            text = "petrosmalkhasyan13@gmail.com",
                            style = GmailTypography.subtitle2,
                            color = GmailThemeColors.onSurface
                        )
                    }
                }

                OutlinedButton(
                    modifier = Modifier
                        .width(234.dp)
                        .padding(all = 16.dp)
                        .height(34.dp)
                        .align(CenterHorizontally),
                    onClick = { },
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(
                        width = 1.dp,
                        color = GmailThemeColors.onSecondary
                    )
                ) {
                    Text(
                        text = stringResource(id = R.string.manage_acc),
                        style = GmailTypography.caption,
                        textAlign = TextAlign.Center,
                        color = GmailThemeColors.onSurface
                    )
                }
                BaseLine()

                CustomRow(
                    title = stringResource(id = R.string.add_another_acc),
                    icon = Icons.Default.Person
                )

                CustomRow(
                    title = stringResource(id = R.string.manage_acc_on_this_device),
                    icon = Icons.Default.Settings
                )

                BaseLine()

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        modifier = Modifier.padding(start = 32.dp),
                        text = stringResource(id = R.string.privacy_policy),
                        style = GmailTypography.overline,
                        textAlign = TextAlign.Center,
                        color = GmailThemeColors.onSurface
                    )
                    Text(
                        modifier = Modifier.padding(end = 32.dp),
                        text = stringResource(id = R.string.terms_of_service),
                        style = GmailTypography.overline,
                        textAlign = TextAlign.Center,
                        color = GmailThemeColors.onSurface
                    )
                }

            }
        }
    }
}

@Composable
fun CustomRow(
    title: String,
    icon: ImageVector,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            modifier = Modifier.size(16.dp),
            imageVector = icon,
            contentDescription = ""
        )

        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = title,
            style = GmailTypography.body2,
            color = GmailThemeColors.onSurface
        )
    }
}
