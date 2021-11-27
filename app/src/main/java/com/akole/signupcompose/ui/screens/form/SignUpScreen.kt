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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.akole.signupcompose.R
import com.akole.signupcompose.ui.CustomOutlinedTextField
import com.akole.signupcompose.ui.screens.form.SignUpScreenDefaults.ArrangementSpacedBy
import com.akole.signupcompose.ui.screens.form.SignUpScreenDefaults.BoxPaddingValues

@Composable
fun SignUpScreen(
    firstNameText: String,
    lastNameText: String,
    phoneNumberText: String,
    onFirstNameValueChange: (String) -> Unit,
    onLastNameValueChange: (String) -> Unit,
    onPhoneNumberValueChange: (String) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(PaddingValues(BoxPaddingValues))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(ArrangementSpacedBy)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(ArrangementSpacedBy)
            ) {
                Box(Modifier.weight(1f)) {
                    CustomOutlinedTextField(
                        text = firstNameText,
                        onValueChange = onFirstNameValueChange,
                        label = stringResource(id = R.string.sign_up_first_name_label_text),
                    )
                }
                Box(Modifier.weight(1f)) {
                    CustomOutlinedTextField(
                        text = lastNameText,
                        onValueChange = onLastNameValueChange,
                        label = stringResource(id = R.string.sign_up_last_name_label_text),
                        )
                }
            }
            CustomOutlinedTextField(
                text = phoneNumberText,
                onValueChange = onPhoneNumberValueChange,
                label = stringResource(id = R.string.sign_up_phone_number_label_text)
            )
        }
    }
}

object SignUpScreenDefaults {
    val ArrangementSpacedBy = 20.dp
    val BoxPaddingValues = 10.dp
}

@Composable
@Preview(showBackground = true)
fun SignUpScreenPreview() {
    var firstNameText by rememberSaveable { mutableStateOf("") }
    var lastNameText by rememberSaveable { mutableStateOf("") }
    var phoneNumberText by rememberSaveable { mutableStateOf("") }
    val onFirstNameValueChange: (String) -> Unit = {
        firstNameText = it
    }
    val onLastNameValueChange: (String) -> Unit = {
        lastNameText = it
    }
    val onPhoneNumberValueChange: (String) -> Unit = {
        phoneNumberText = it
    }

    SignUpScreen(
        firstNameText = firstNameText,
        lastNameText = lastNameText,
        phoneNumberText = phoneNumberText,
        onFirstNameValueChange = onFirstNameValueChange,
        onLastNameValueChange = onLastNameValueChange,
        onPhoneNumberValueChange = onPhoneNumberValueChange
    )
}