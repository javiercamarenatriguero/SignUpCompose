package com.akole.signupcompose.ui.screens.form

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.akole.signupcompose.R
import com.akole.signupcompose.ui.CustomOutlinedTextField

@Composable
fun SignUpContent(
    viewModel: SignUpViewModel
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(PaddingValues(SignUpScreenDefaults.BoxPaddingValues))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(SignUpScreenDefaults.ArrangementSpacedBy)
        ) {
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
        }
    }
}

object SignUpScreenDefaults {
    val ArrangementSpacedBy = 20.dp
    val BoxPaddingValues = 10.dp
}