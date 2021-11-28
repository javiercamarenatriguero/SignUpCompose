package com.akole.signupcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.ExperimentalComposeUiApi
import com.akole.signupcompose.ui.screens.form.SignUpScreen
import com.akole.signupcompose.ui.screens.form.SignUpViewModel
import com.akole.signupcompose.ui.theme.SignUpComposeTheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel by viewModels<SignUpViewModel>()
            SignUpComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    SignUpScreen(
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}
