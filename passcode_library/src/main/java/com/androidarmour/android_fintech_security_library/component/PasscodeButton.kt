package com.androidarmour.android_fintech_security_library.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.androidarmour.android_fintech_security_library.R
import com.androidarmour.android_fintech_security_library.theme.forgotButtonStyle
import com.androidarmour.android_fintech_security_library.theme.skipButtonStyle
import com.androidarmour.android_fintech_security_library.theme.useTouchIdButtonStyle

@Composable
fun PasscodeSkipButton(
    onSkipButton: () -> Unit,
    hasPassCode: Boolean
) {
    if (!hasPassCode) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(
                onClick = { onSkipButton.invoke() }
            ) {
                Text(text = stringResource(R.string.skip), style = skipButtonStyle)
            }
        }
    }

}

@Composable
fun PasscodeForgotButton(
    onForgotButton: () -> Unit,
    hasPassCode: Boolean
) {
    if (hasPassCode) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            TextButton(
                onClick = { onForgotButton.invoke() }
            ) {
                Text(
                    text = stringResource(R.string.forgot_passcode_login_manually),
                    style = forgotButtonStyle
                )
            }
        }
    }
}

@Composable
fun UseTouchIdButton(
    onClick: () -> Unit,
    hasPassCode: Boolean
){
    if(hasPassCode) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            TextButton(
                onClick = onClick
            ) {
                Text(text = stringResource(R.string.use_touchId), style = useTouchIdButtonStyle)
            }
        }
    }
}