package com.akole.signupcompose.ui.screens.form

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.akole.signupcompose.R
import com.akole.signupcompose.ui.CustomOutlinedTextField

@Composable
fun EmailTextField(
    email: String,
    onEmailChange: (String) -> Unit,
) {
    CustomOutlinedTextField(
        value = email,
        keyboardType = KeyboardType.Email,
        onValueChange = onEmailChange,
        label = stringResource(id = R.string.sign_up_email_label_text),
    )
}