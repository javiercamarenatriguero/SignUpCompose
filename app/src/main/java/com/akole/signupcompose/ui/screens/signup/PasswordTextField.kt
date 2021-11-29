package com.akole.signupcompose.ui.screens.signup

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.akole.signupcompose.R
import com.akole.signupcompose.ui.CustomOutlinedTextField

@Composable
fun PasswordTextField(
    password: String,
    isPasswordVisible: Boolean,
    onPasswordChange: (String) -> Unit,
    onPasswordVisibilityClick: () -> Unit,
    onKeyboardDone: () -> Unit,
    isError: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CustomOutlinedTextField(
            value = password,
            keyboardType = KeyboardType.Password,
            visualTransformation = if(isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            onValueChange = onPasswordChange,
            label = stringResource(id = R.string.sign_up_password_label_text),
            onKeyboardDone = onKeyboardDone,
            imeAction = ImeAction.Done,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Password,
                    contentDescription = "",
                    modifier = Modifier.padding(start = 10.dp, end = 5.dp)
                )
            },
            isError = isError,
            errorText = stringResource(id = R.string.sign_up_password_error_text),
        )
        IconButton(
            onClick = onPasswordVisibilityClick
        ) {
            Icon(
                imageVector = if (isPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                contentDescription = "Password visibility icon"
            )
        }
    }
}