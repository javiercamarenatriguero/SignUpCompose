package com.akole.signupcompose.ui.screens.signup

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.akole.signupcompose.R
import com.akole.signupcompose.ui.CustomOutlinedTextField

@Composable
fun EmailTextField(
    email: String,
    onEmailChange: (String) -> Unit,
    onKeyboardNext: () -> Unit,
    isError: Boolean
) {
    CustomOutlinedTextField(
        value = email,
        keyboardType = KeyboardType.Email,
        onValueChange = onEmailChange,
        label = stringResource(id = R.string.sign_up_email_label_text),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = "",
                modifier = Modifier.padding(start = 10.dp, end = 5.dp)
            )
        },
        onKeyboardNext = onKeyboardNext,
        isError = isError,
        errorText = stringResource(id = R.string.sign_up_email_error_text),
    )
}