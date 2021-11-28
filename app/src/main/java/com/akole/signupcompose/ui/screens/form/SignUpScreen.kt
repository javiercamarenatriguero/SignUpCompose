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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.akole.signupcompose.R
import com.akole.signupcompose.ui.CustomOutlinedTextField
import com.akole.signupcompose.ui.screens.form.SignUpScreenDefaults.ArrangementSpacedBy
import com.akole.signupcompose.ui.screens.form.SignUpScreenDefaults.BoxPaddingValues
import com.akole.signupcompose.ui.screens.form.SignUpViewModel.OneShotEvent
import com.akole.signupcompose.ui.screens.form.SignUpViewModel.ViewEvent
import kotlinx.coroutines.flow.collect

@ExperimentalComposeUiApi
@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel
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
                        text = viewModel.viewState.firstName,
                        onValueChange = {
                            viewModel.on(ViewEvent.FirstNameChange(it))
                        },
                        label = stringResource(id = R.string.sign_up_first_name_label_text)
                    )
                }
                Box(Modifier.weight(1f)) {
                    CustomOutlinedTextField(
                        text = viewModel.viewState.lastName,
                        onValueChange = {
                            viewModel.on(ViewEvent.LastNameChange(it))
                        },
                        label = stringResource(id = R.string.sign_up_last_name_label_text),
                    )
                }
            }
            CustomOutlinedTextField(
                text = viewModel.viewState.phoneNumber,
                onValueChange = {
                    viewModel.on(ViewEvent.PhoneNumberChange(it))
                },
                label = stringResource(id = R.string.sign_up_phone_number_label_text)
            )
        }
    }

    val keyboardController = LocalSoftwareKeyboardController.current
    LaunchedEffect(viewModel.oneShotEvents) {
        viewModel.oneShotEvents.collect { event ->
            when (event) {
                OneShotEvent.HideKeyboard -> keyboardController?.hide()
            }
        }
    }

}

object SignUpScreenDefaults {
    val ArrangementSpacedBy = 20.dp
    val BoxPaddingValues = 10.dp
}

@ExperimentalComposeUiApi
@Composable
@Preview(showBackground = true)
fun SignUpScreenPreview() {
    SignUpScreen(
        viewModel = SignUpViewModel()
    )
}