package com.akole.signupcompose.ui.screens.form

import androidx.lifecycle.ViewModel
import com.akole.signupcompose.model.User

class SignUpViewModel: ViewModel() {

    internal data class ViewState(
        val firstName: String = "",
        val lastName: String = "",
        val country: String = "",
        val phoneNumber: String = "",
        val birthdate: String = "",
        val isLoading: Boolean = false
    )

    internal sealed interface ViewEvent {
        data class FirstNameChange(val value: String) : ViewEvent
        data class LastNameChange(val value: String) : ViewEvent
        data class PhoneNumberChange(val value: String) : ViewEvent
        data class BirthdateChange(val value: String) : ViewEvent
        object SignUpButtonClick : ViewEvent
        object OnKeyboardDone : ViewEvent
        object OnKeyboardNext : ViewEvent
        object NavigateBack : ViewEvent
    }

    internal sealed interface OneShotEvent {
        object ClosePage : OneShotEvent
        object HideKeyboard : OneShotEvent
        data class SignUpCompleted(val user: User) : OneShotEvent
    }
}