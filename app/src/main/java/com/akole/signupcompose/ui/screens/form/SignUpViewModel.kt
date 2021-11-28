package com.akole.signupcompose.ui.screens.form

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akole.signupcompose.model.User
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class SignUpViewModel: ViewModel() {

    var viewState by mutableStateOf(ViewState())
        private set

    private val _oneShotEvents = Channel<OneShotEvent>(Channel.BUFFERED)
    val oneShotEvents: Flow<OneShotEvent> = _oneShotEvents.receiveAsFlow()

    fun on(event: ViewEvent): Unit = with(event) {
        when (this) {
            is ViewEvent.FirstNameChange -> updateState(firstName = value)
            is ViewEvent.LastNameChange -> updateState(lastName = value)
            is ViewEvent.PhoneNumberChange -> updateState(phoneNumber = value)
            is ViewEvent.CountryChange -> onCountryChange(country = value)
            is ViewEvent.EmailChange -> updateState(email = value)
            is ViewEvent.PasswordChange -> updateState(password = value)
            is ViewEvent.BirthdateChange -> updateState(birthdate = value)
            ViewEvent.PasswordSwitchClick -> updateState(isPasswordVisible = !viewState.isPasswordVisible)
            ViewEvent.CountryClick -> onCountryClick()
            ViewEvent.SignUpButtonClick -> emit(OneShotEvent.SignUpCompleted(viewState.toUser()))
            ViewEvent.OnKeyboardDone -> emit(OneShotEvent.HideKeyboard)
            ViewEvent.NavigateBack -> emit(OneShotEvent.ClosePage)
            else -> {}
        }
    }

    private fun updateState(
        firstName: String = viewState.firstName,
        lastName: String = viewState.lastName,
        phoneNumber: String = viewState.phoneNumber,
        country: String = viewState.country,
        birthdate: String = viewState.birthdate,
        email: String = viewState.email,
        password: String = viewState.password,
        isPasswordVisible: Boolean = viewState.isPasswordVisible,
        isSignUpButtonEnabled: Boolean = viewState.isSignUpButtonEnabled
    ) {
        viewState = ViewState(
            firstName = firstName,
            lastName = lastName,
            phoneNumber = phoneNumber,
            country = country,
            birthdate = birthdate,
            email = email,
            password = password,
            isPasswordVisible = isPasswordVisible,
            isSignUpButtonEnabled = isSignUpButtonEnabled
        )
    }

    private fun onCountryClick() {
        emit(OneShotEvent.HideKeyboard)
        emit(OneShotEvent.OpenCountryModalSheet)
    }
    private fun onCountryChange(country: String) {
        updateState(country = country)
        emit(OneShotEvent.HideCountryModalSheet)
    }

    private fun emit(event: OneShotEvent) {
        viewModelScope.launch {
            _oneShotEvents.send(event)
        }
    }

    data class ViewState(
        val firstName: String = "",
        val lastName: String = "",
        val country: String = "",
        val phoneNumber: String = "",
        val birthdate: String = "",
        val email: String = "",
        val password: String = "",
        val isSignUpButtonEnabled: Boolean = false,
        val isPasswordVisible: Boolean = false
    )

    private fun ViewState.toUser() =
        User(
            firstName = firstName,
            lastName = lastName,
            country = country,
            phoneNumber = phoneNumber,
            birthdate = birthdate,
            email = email,
            password = password
        )

    sealed interface ViewEvent {
        data class FirstNameChange(val value: String) : ViewEvent
        data class LastNameChange(val value: String) : ViewEvent
        data class PhoneNumberChange(val value: String) : ViewEvent
        data class CountryChange(val value: String) : ViewEvent
        data class BirthdateChange(val value: String) : ViewEvent
        data class EmailChange(val value: String) : ViewEvent
        data class PasswordChange(val value: String) : ViewEvent
        object SignUpButtonClick : ViewEvent
        object CountryClick : ViewEvent
        object PasswordSwitchClick: ViewEvent
        object OnKeyboardDone : ViewEvent
        object OnKeyboardNext : ViewEvent
        object NavigateBack : ViewEvent
    }

    sealed interface OneShotEvent {
        object ClosePage : OneShotEvent
        object HideKeyboard : OneShotEvent
        object OpenCountryModalSheet : OneShotEvent
        object HideCountryModalSheet : OneShotEvent
        data class SignUpCompleted(val user: User) : OneShotEvent
    }
}