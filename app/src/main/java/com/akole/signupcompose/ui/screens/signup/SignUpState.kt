package com.akole.signupcompose.ui.screens.signup

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun rememberSignUpState(
    modalBottomSheetState: ModalBottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden),
    focusManager: FocusManager = LocalFocusManager.current,
    keyboardController: SoftwareKeyboardController? = LocalSoftwareKeyboardController.current,
    coroutineScope: CoroutineScope = rememberCoroutineScope()
): SignUpState = remember(modalBottomSheetState, focusManager, keyboardController) {
    SignUpState(modalBottomSheetState, focusManager, keyboardController, coroutineScope)
}

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
class SignUpState
 constructor(
     val modalBottomSheetState: ModalBottomSheetState,
     private val focusManager: FocusManager,
     private val keyboardController: SoftwareKeyboardController?,
     private val coroutineScope: CoroutineScope
) {
    fun hideKeyboard() {
        keyboardController?.hide()
    }
    fun hideModalSheet() {
        coroutineScope.launch { modalBottomSheetState.hide() }
    }
    fun showModalSheet() {
        coroutineScope.launch { modalBottomSheetState.show() }
    }
    fun moveFocus(focusDirection: FocusDirection) {
        coroutineScope.launch { focusManager.moveFocus(focusDirection) }
    }
    fun clearFocus() {
        coroutineScope.launch { focusManager.clearFocus() }
    }
}
