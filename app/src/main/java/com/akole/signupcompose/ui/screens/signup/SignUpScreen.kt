package com.akole.signupcompose.ui.screens.signup

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.focus.FocusDirection
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
    val signUpState: SignUpState = rememberSignUpState()

    ModalBottomSheetLayout(
        sheetState = signUpState.modalBottomSheetState,
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

    LaunchedEffect(viewModel.oneShotEvents) {
        viewModel.oneShotEvents.collect { event ->
            when (event) {
                OneShotEvent.OpenCountryModalSheet -> signUpState.showModalSheet()
                OneShotEvent.HideKeyboard -> signUpState.hideKeyboard()
                OneShotEvent.HideCountryModalSheet -> signUpState.hideModalSheet()
                OneShotEvent.FocusRight -> signUpState.moveFocus(FocusDirection.Right)
                OneShotEvent.FocusDown -> signUpState.moveFocus(FocusDirection.Down)
                OneShotEvent.FocusClear -> signUpState.clearFocus()
                else -> {}
            }
        }
    }
}
