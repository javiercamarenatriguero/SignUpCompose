package com.akole.signupcompose.ui.screens.form

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import com.akole.signupcompose.ui.screens.form.SignUpViewModel.OneShotEvent
import com.akole.signupcompose.ui.screens.form.SignUpViewModel.ViewEvent
import kotlinx.coroutines.flow.collect

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel
) {
    val modalBottomSheetState: ModalBottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    ModalBottomSheetLayout(
        sheetState = modalBottomSheetState,
        sheetContent = {
            CountryListModalSheetContent(
                onItemClick = {
                    viewModel.on(ViewEvent.CountryChange(it))
                }
            )
        }
    ) {
        SignUpContent(viewModel = viewModel)
    }

    val keyboardController = LocalSoftwareKeyboardController.current
    LaunchedEffect(viewModel.oneShotEvents) {
        viewModel.oneShotEvents.collect { event ->
            when (event) {
                OneShotEvent.OpenCountryModalSheet -> modalBottomSheetState?.show()
                OneShotEvent.HideKeyboard -> keyboardController?.hide()
                OneShotEvent.HideCountryModalSheet -> modalBottomSheetState?.hide()
            }
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
@Preview(showBackground = true)
fun SignUpScreenPreview() {
    SignUpScreen(
        viewModel = SignUpViewModel()
    )
}