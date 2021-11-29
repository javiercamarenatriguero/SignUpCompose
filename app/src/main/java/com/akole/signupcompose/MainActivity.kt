package com.akole.signupcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.core.view.WindowCompat
import com.akole.signupcompose.ui.screens.form.SignUpScreen
import com.akole.signupcompose.ui.screens.form.SignUpViewModel
import com.akole.signupcompose.ui.theme.SignUpComposeTheme
import com.google.accompanist.insets.ProvideWindowInsets

class MainActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val viewModel by viewModels<SignUpViewModel>()
            SignUpComposeTheme {
                ProvideWindowInsets(windowInsetsAnimationsEnabled = true) {
                    Surface(color = MaterialTheme.colors.background) {
                        SignUpScreen(
                            viewModel = viewModel
                        )
                    }
                }
            }
        }
    }
}
