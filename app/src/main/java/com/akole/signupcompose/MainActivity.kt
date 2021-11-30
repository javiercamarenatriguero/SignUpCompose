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
import com.akole.signupcompose.ui.screens.signup.SignUpViewModel
import com.akole.signupcompose.ui.theme.SignUpComposeTheme
import com.google.accompanist.insets.ProvideWindowInsets

class MainActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val viewModel by viewModels<SignUpViewModel>()
            SignUpComposeTheme {
                ProvideWindowInsets(windowInsetsAnimationsEnabled = true) {
                    Surface(color = MaterialTheme.colors.background) {
                        SignUpComposeApp(viewModel = viewModel)
                    }
                }
            }
        }
    }
}
