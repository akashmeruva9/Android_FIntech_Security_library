package com.androidarmour.android_fintech_security_library.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.androidarmour.android_fintech_security_library.R
import com.androidarmour.android_fintech_security_library.utility.Step

@Composable
fun PasscodeToolbar(activeStep: Step, hasPasscode: Boolean) {
    var exitWarningDialogVisible by remember { mutableStateOf(false) }
    ExitWarningDialog(
        visible = exitWarningDialogVisible,
        onConfirm = {},
        onDismiss = {
            exitWarningDialogVisible = false
        }
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        if (!hasPasscode) {
            PasscodeStepIndicator(
                activeStep = activeStep
            )
        }
    }
}

@Composable
fun ExitWarningDialog(
    visible: Boolean,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    if (visible) {
        AlertDialog(
            shape = MaterialTheme.shapes.large,
            containerColor = Color.White,
            title = {
                Text(
                    text = stringResource(R.string.are_you_sure_you_want_to_exit),
                    color = Color.Black
                )
            },
            confirmButton = {
                TextButton(onClick = onConfirm) {
                    Text(text = stringResource(R.string.exit))
                }
            },
            dismissButton = {
                TextButton(onClick = onDismiss) {
                    Text(text = stringResource(R.string.cancel))
                }
            },
            onDismissRequest = onDismiss
        )
    }
}