package com.akole.signupcompose.ui.screens.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.akole.signupcompose.R
import com.akole.signupcompose.ui.common.CustomDialog
import com.akole.signupcompose.ui.screens.signup.fields.BirthDateTextField
import com.akole.signupcompose.ui.screens.signup.fields.EmailTextField
import com.akole.signupcompose.ui.screens.signup.fields.NameRow
import com.akole.signupcompose.ui.screens.signup.fields.PasswordTextField
import com.akole.signupcompose.ui.screens.signup.fields.PhoneTextField
import com.akole.signupcompose.ui.screens.signup.fields.SignUpButton
import com.akole.signupcompose.ui.theme.Shapes
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
    ) {
        Column(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.sign_up_column_padding))
                .clip(Shapes.medium),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.sign_up_column_arrangement_space))
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
                },
                onKeyboardNext = {
                    viewModel.on(SignUpViewModel.ViewEvent.OnKeyboardNext)
                },
                onKeyboardDown = {
                    viewModel.on(SignUpViewModel.ViewEvent.OnKeyboardDown)
                },
                isFirstNameError = viewModel.isFirstNameNotValid(),
                isLastNameError = viewModel.isLastNameNotValid()
            )
            PhoneTextField(
                phoneNumber = viewModel.viewState.phoneNumber,
                country = viewModel.viewState.country,
                onPhoneNumberChange = { phoneNumber ->
                    viewModel.on(SignUpViewModel.ViewEvent.PhoneNumberChange(phoneNumber))
                },
                onPhonePrefixClick = {
                    viewModel.on(SignUpViewModel.ViewEvent.CountryClick)
                },
                onKeyboardNext = {
                    viewModel.on(SignUpViewModel.ViewEvent.OnKeyboardDown)
                },
                isError = viewModel.isPhoneNumberNotValid()
            )
            BirthDateTextField(
                birthdate = viewModel.viewState.birthdate,
                onBirthdateChange = {
                    viewModel.on(SignUpViewModel.ViewEvent.BirthdateChange(it))
                },
                onKeyboardNext = {
                    viewModel.on(SignUpViewModel.ViewEvent.OnKeyboardDown)
                },
                isError = viewModel.isBirthdateNotValid()

            )
            EmailTextField(
                email = viewModel.viewState.email,
                onEmailChange = {
                    viewModel.on(SignUpViewModel.ViewEvent.EmailChange(it))
                },
                onKeyboardNext = {
                    viewModel.on(SignUpViewModel.ViewEvent.OnKeyboardDown)
                },
                isError = viewModel.isEmailNotValid()
            )
            PasswordTextField(
                password= viewModel.viewState.password,
                isPasswordVisible = viewModel.viewState.isPasswordVisible,
                onPasswordChange = {
                    viewModel.on(SignUpViewModel.ViewEvent.PasswordChange(it))
                },
                onPasswordVisibilityClick = {
                    viewModel.on(SignUpViewModel.ViewEvent.PasswordSwitchClick)
                },
                onKeyboardDone = {
                    viewModel.on(SignUpViewModel.ViewEvent.OnKeyboardDone)
                },
                isError = viewModel.isPasswordNotValid()
            )
            SignUpButton(
                onClick = {
                    viewModel.on(SignUpViewModel.ViewEvent.SignUpButtonClick)
                }
            )
            if (viewModel.viewState.isSuccessDialogVisible) {
                CustomDialog(
                    title = stringResource(id = R.string.sign_up_success_dialog_title_text),
                    doneButtonText = stringResource(id = R.string.sign_up_success_dialog_done_button_text),
                    onDismissRequest = {
                        viewModel.on(SignUpViewModel.ViewEvent.OnDialogCloseClicked)
                    },
                    editButtonText = stringResource(id = R.string.sign_up_success_dialog_edit_button_text),
                    onEditButtonClick = {
                        viewModel.on(SignUpViewModel.ViewEvent.OnDialogEditClicked)
                    },
                    content = {
                        SuccessDialogContent(
                            viewModel.viewState.firstName,
                            viewModel.viewState.lastName,
                            viewModel.viewState.country,
                            viewModel.viewState.phoneNumber,
                            viewModel.viewState.email,
                        )
                    }
                )
            }
        }
    }
}
