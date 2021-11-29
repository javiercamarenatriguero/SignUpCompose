package com.akole.signupcompose.ui.screens.form

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.navigationBarsWithImePadding

@Composable
fun SignUpContent(
    viewModel: SignUpViewModel
) {
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsWithImePadding()
            .verticalScroll(state = scrollState, reverseScrolling = true)
            .padding(horizontal = 16.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(SignUpScreenDefaults.ArrangementSpacedBy)
        ) {
            TitleText()
            NameRow(
                firstName = viewModel.viewState.firstName,
                lastName = viewModel.viewState.lastName,
                onFirstNameChange = {
                    viewModel.on(SignUpViewModel.ViewEvent.FirstNameChange(it))
                },
                onLastNameChange = {
                    viewModel.on(SignUpViewModel.ViewEvent.LastNameChange(it))
                }
            )
            PhoneTextField(
                phoneNumber = viewModel.viewState.phoneNumber,
                country = viewModel.viewState.country,
                onPhoneNumberChange = { phoneNumber ->
                    viewModel.on(SignUpViewModel.ViewEvent.PhoneNumberChange(phoneNumber))
                },
                onPhonePrefixClick = {
                    viewModel.on(SignUpViewModel.ViewEvent.CountryClick)
                }
            )
            BirthDateTextField(
                birthdate = viewModel.viewState.birthdate,
                onBirthdateChange = {
                    viewModel.on(SignUpViewModel.ViewEvent.BirthdateChange(it))
                }
            )
            EmailTextField(
                email = viewModel.viewState.email,
                onEmailChange = {
                    viewModel.on(SignUpViewModel.ViewEvent.EmailChange(it))
                }
            )
            PasswordTextField(
                password= viewModel.viewState.password,
                isPasswordVisible = viewModel.viewState.isPasswordVisible,
                onPasswordChange = {
                    viewModel.on(SignUpViewModel.ViewEvent.PasswordChange(it))
                },
                onPasswordVisibilityClick = {
                    viewModel.on(SignUpViewModel.ViewEvent.PasswordSwitchClick)
                }
            )
            SignUpButton(
                onClick = {
                    viewModel.on(SignUpViewModel.ViewEvent.SignUpButtonClick)
                },
                enabled = viewModel.viewState.isSignUpButtonEnabled
            )
        }
    }
}

object SignUpScreenDefaults {
    val ArrangementSpacedBy = 20.dp
    val BoxPaddingValues = 10.dp
}