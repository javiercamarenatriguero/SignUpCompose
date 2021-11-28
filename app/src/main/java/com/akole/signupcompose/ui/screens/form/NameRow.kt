package com.akole.signupcompose.ui.screens.form

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.akole.signupcompose.R
import com.akole.signupcompose.ui.CustomOutlinedTextField

@Composable
fun NameRow(
    firstName: String,
    lastName: String,
    onFirstNameChange: (String) -> Unit,
    onLastNameChange: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(SignUpScreenDefaults.ArrangementSpacedBy)
    ) {
        Box(Modifier.weight(1f)) {
            CustomOutlinedTextField(
                text = firstName,
                onValueChange = onFirstNameChange,
                label = stringResource(id = R.string.sign_up_first_name_label_text)
            )
        }
        Box(Modifier.weight(1f)) {
            CustomOutlinedTextField(
                text = lastName,
                onValueChange = onLastNameChange,
                label = stringResource(id = R.string.sign_up_last_name_label_text),
            )
        }
    }
}