package com.example.gmail.ui.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gmail.R
import com.example.gmail.ui.component.LoginTextField
import com.example.gmail.ui.component.base_navigation.BaseNavigationRoute
import com.example.gmail.ui.theme.GmailThemeColors
import com.example.gmail.ui.theme.GmailTypography

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    val (email, setEmail) = remember { mutableStateOf("") }
    val (password, setPassword) = remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.lbl_signin),
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        LoginTextField(
            value = email,
            placeholder = "Email",
            onValueChange = setEmail,
        )

        Spacer(modifier = Modifier.height(16.dp))

        LoginTextField(
            value = password,
            placeholder = "Password",
            onValueChange = setPassword,
            secureText = true
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                navController.navigate(BaseNavigationRoute.Home.screen_route)
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(GmailThemeColors.surface)
        ) {
            Text(text = "Sign in")
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(
            onClick = { /* Handle forgot password button click */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Forgot password?",
                style = GmailTypography.subtitle1,
                color = GmailThemeColors.onSurface
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "Don't have an account?", modifier = Modifier.padding(bottom = 8.dp)
        )

        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(GmailThemeColors.onSecondary),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.create_acc),
                color = MaterialTheme.colors.onSurface
            )
        }
    }
}
