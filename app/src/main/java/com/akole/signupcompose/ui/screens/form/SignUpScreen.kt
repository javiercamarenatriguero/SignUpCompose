package com.akole.signupcompose.ui.screens.form

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.akole.signupcompose.R
import com.akole.signupcompose.ui.CustomOutlinedTextField
import com.akole.signupcompose.ui.screens.form.SignUpScreenDefaults.ArrangementSpacedBy
import com.akole.signupcompose.ui.screens.form.SignUpScreenDefaults.BoxPaddingValues
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