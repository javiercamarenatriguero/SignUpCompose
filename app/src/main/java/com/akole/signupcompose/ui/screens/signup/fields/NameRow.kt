package com.akole.signupcompose.ui.screens.signup.fields

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.akole.signupcompose.R
import com.akole.signupcompose.ui.common.CustomOutlinedTextField

@Composable
fun NameRow(
    firstName: String,
    lastName: String,
    onFirstNameChange: (String) -> Unit,
    onLastNameChange: (String) -> Unit,
    onKeyboardNext: () -> Unit,
    onKeyboardDown: () -> Unit,
    isFirstNameError: Boolean,
    isLastNameError: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.name_row_space_by))
    ) {
        Box(Modifier.weight(1f)) {
            CustomOutlinedTextField(
                value = firstName,
                onValueChange = onFirstNameChange,
                label = stringResource(id = R.string.sign_up_first_name_label_text),
                onKeyboardNext = onKeyboardNext,
                isError = isFirstNameError,
                errorText = stringResource(id = R.string.sign_up_first_name_error_text),
            )
        }
        Box(Modifier.weight(1f)) {
            CustomOutlinedTextField(
                value = lastName,
                onValueChange = onLastNameChange,
                label = stringResource(id = R.string.sign_up_last_name_label_text),
                onKeyboardNext = onKeyboardDown,
                isError =isLastNameError,
                errorText = stringResource(id = R.string.sign_up_last_name_error_text),
            )
        }
    }
}