package com.akole.signupcompose

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.akole.signupcompose.ui.screens.signup.SignUpScreen
import com.akole.signupcompose.ui.screens.signup.SignUpViewModel

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun SignUpComposeApp(
    appState: AppState = rememberSignUpState(),
    viewModel: SignUpViewModel
) {
    SignUpScreen(
        viewModel = viewModel,
        appState = appState
    )
}