package com.androidarmour.android_fintech_security_library

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.androidarmour.android_fintech_security_library.component.PasscodeScreen
import com.androidarmour.android_fintech_security_library.theme.MifosPasscodeTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var passcodeRepository: PasscodeRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MifosPasscodeTheme {
                PasscodeScreen(
                    onForgotButton = { onPasscodeForgot() },
                    onSkipButton = { onPasscodeSkip() },
                    onPasscodeConfirm = { onPassCodeReceive(it) },
                    onPasscodeRejected = { onPasscodeReject() },
                    activity = this,
                    onBiometricAuthenticated = { launchNextActivity() }
                )
            }
        }
    }

    private fun onPassCodeReceive(passcode: String) {
        if (passcodeRepository.getSavedPasscode() == passcode) {
            launchNextActivity()
        }
    }

    private fun launchNextActivity() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    private fun onPasscodeReject() {}

    private fun onPasscodeForgot() {
        // Add logic to redirect user to login page
        Toast.makeText(this, "Forgot Passcode", Toast.LENGTH_SHORT).show()
    }

    private fun onPasscodeSkip() {
        Toast.makeText(this, "Skip Button", Toast.LENGTH_SHORT).show()
        finish()
    }
}