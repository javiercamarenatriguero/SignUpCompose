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
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(SignUpScreenDefaults.ArrangementSpacedBy)
            ) {
                Box(Modifier.weight(1f)) {
                    CustomOutlinedTextField(
                        text = viewModel.viewState.firstName,
                        onValueChange = {
                            viewModel.on(SignUpViewModel.ViewEvent.FirstNameChange(it))
                        },
                        label = stringResource(id = R.string.sign_up_first_name_label_text)
                    )
                }
                Box(Modifier.weight(1f)) {
                    CustomOutlinedTextField(
                        text = viewModel.viewState.lastName,
                        onValueChange = {
                            viewModel.on(SignUpViewModel.ViewEvent.LastNameChange(it))
                        },
                        label = stringResource(id = R.string.sign_up_last_name_label_text),
                    )
                }
            }
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
        }
    }
}

object SignUpScreenDefaults {
    val ArrangementSpacedBy = 20.dp
    val BoxPaddingValues = 10.dp
}