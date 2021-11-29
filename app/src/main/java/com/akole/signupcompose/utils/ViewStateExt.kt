package com.akole.signupcompose.utils

import com.akole.signupcompose.ui.screens.signup.SignUpViewModel

fun SignUpViewModel.ViewState.isReadyToSignUp() =
    email.isValidEmail() &&
            password.isValidPassword() &&
            firstName.isNotEmpty() &&
            lastName.isNotEmpty() &&
            birthdate.isValidDate() &&
            phoneNumber.isValidPhoneNumber()
