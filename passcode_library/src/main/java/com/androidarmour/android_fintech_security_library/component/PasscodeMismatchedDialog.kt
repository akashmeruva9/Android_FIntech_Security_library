package com.androidarmour.android_fintech_security_library.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.androidarmour.android_fintech_security_library.R

@Composable
fun PasscodeMismatchedDialog(
    visible: Boolean,
    onDismiss: () -> Unit
) {
    if (visible) {
        AlertDialog(
            shape = MaterialTheme.shapes.large,
            containerColor = Color.White,
            title = {
                Text(
                    text = stringResource(R.string.passcode_do_not_match),
                    color = Color.Black
                )
            },
            confirmButton = {
                TextButton(onClick = onDismiss) {
                    Text(text = stringResource(R.string.try_again), color = Color.Black)
                }
            },
            onDismissRequest = onDismiss
        )
    }
}