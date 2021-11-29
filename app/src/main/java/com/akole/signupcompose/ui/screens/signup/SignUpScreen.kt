package com.akole.signupcompose.ui.screens.signup

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.akole.signupcompose.ui.screens.signup.SignUpViewModel.OneShotEvent
import com.akole.signupcompose.ui.screens.signup.SignUpViewModel.ViewEvent
import kotlinx.coroutines.flow.collect

@OptIn(ExperimentalMaterialApi::class)
@ExperimentalComposeUiApi
@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel
) {
    val modalBottomSheetState: ModalBottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val focusManager = LocalFocusManager.current
    ModalBottomSheetLayout(
        sheetState = modalBottomSheetState,
        sheetContent = {
            CountryListModalSheetContent(
                onItemClick = {
                    viewModel.on(ViewEvent.CountryChange(it))
                }
            )
        },
        sheetShape = RoundedCornerShape(20.dp)
    ) {
        SignUpContent(viewModel = viewModel)
    }

    val keyboardController = LocalSoftwareKeyboardController.current
    LaunchedEffect(viewModel.oneShotEvents) {
        viewModel.oneShotEvents.collect { event ->
            when (event) {
                OneShotEvent.OpenCountryModalSheet -> modalBottomSheetState.show()
                OneShotEvent.HideKeyboard -> keyboardController?.hide()
                OneShotEvent.HideCountryModalSheet -> modalBottomSheetState.hide()
                OneShotEvent.FocusRight -> focusManager.moveFocus(FocusDirection.Right)
                OneShotEvent.FocusDown -> focusManager.moveFocus(FocusDirection.Down)
                else -> {}
            }
        }
    }
}
