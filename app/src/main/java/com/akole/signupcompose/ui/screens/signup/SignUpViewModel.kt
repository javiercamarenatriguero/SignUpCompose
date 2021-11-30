package com.akole.signupcompose.ui.screens.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akole.signupcompose.utils.isReadyToSignUp
import com.akole.signupcompose.utils.isValidDate
import com.akole.signupcompose.utils.isValidEmail
import com.akole.signupcompose.utils.isValidPassword
import com.akole.signupcompose.utils.isValidPhoneNumber
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
            is ViewEvent.PhoneNumberChange -> onPhoneChange(phoneNumber = value)
            is ViewEvent.CountryChange -> onCountryChange(country = value)
            is ViewEvent.EmailChange -> updateState(email = value)
            is ViewEvent.PasswordChange -> updateState(password = value)
            is ViewEvent.BirthdateChange -> onBirthdateChange(birthdate = value)
            ViewEvent.PasswordSwitchClick -> updateState(isPasswordVisible = !viewState.isPasswordVisible)
            ViewEvent.CountryClick -> onCountryClick()
            ViewEvent.SignUpButtonClick -> onSignUpDone()
            ViewEvent.OnKeyboardNext -> emit(OneShotEvent.FocusRight)
            ViewEvent.OnKeyboardDown -> emit(OneShotEvent.FocusDown)
            ViewEvent.OnKeyboardDone -> onSignUpDone()
            ViewEvent.NavigateBack -> emit(OneShotEvent.ClosePage)
            ViewEvent.OnDialogCloseClicked -> onSuccessDialogClose()
            ViewEvent.OnDialogEditClicked -> updateState(isSuccessDialogVisible = false)
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
        isSignUpButtonClicked: Boolean = viewState.isSignUpButtonClicked,
        isSuccessDialogVisible: Boolean = viewState.isSuccessDialogVisible
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
            isSignUpButtonClicked = isSignUpButtonClicked,
            isSuccessDialogVisible = isSuccessDialogVisible
        )
    }

    fun isPasswordNotValid(): Boolean =
        viewState.isSignUpButtonClicked && !viewState.password.isValidPassword()

    fun isEmailNotValid(): Boolean =
        viewState.isSignUpButtonClicked && !viewState.email.isValidEmail()

    fun isFirstNameNotValid(): Boolean =
        viewState.isSignUpButtonClicked && viewState.firstName.isEmpty()

    fun isLastNameNotValid(): Boolean =
        viewState.isSignUpButtonClicked && viewState.lastName.isEmpty()

    fun isBirthdateNotValid(): Boolean =
        viewState.isSignUpButtonClicked && !viewState.birthdate.isValidDate()

    fun isPhoneNumberNotValid(): Boolean =
        viewState.isSignUpButtonClicked && !viewState.phoneNumber.isValidPhoneNumber()

    private fun onCountryClick() {
        emit(OneShotEvent.HideKeyboard)
        emit(OneShotEvent.OpenCountryModalSheet)
    }

    private fun onCountryChange(country: String) {
        updateState(country = country)
        emit(OneShotEvent.HideCountryModalSheet)
    }

    private fun onBirthdateChange(birthdate: String) {
        if (birthdate.length <= MAX_BIRTHDATE_CHAR) updateState(birthdate = birthdate)
    }

    private fun onPhoneChange(phoneNumber: String) {
        if (phoneNumber.length <= MAX_PHONE_NUMBER_CHAR) updateState(phoneNumber = phoneNumber)
    }

    private fun onSignUpDone() {
        emit(OneShotEvent.HideKeyboard)
        updateState(isSignUpButtonClicked = true)
        if (viewState.isReadyToSignUp()) {
            updateState(isSuccessDialogVisible = true)
        }
    }

    private fun onSuccessDialogClose() {
        emit(OneShotEvent.FocusClear)
        viewState = ViewState()
    }

    private fun emit(event: OneShotEvent) {
        viewModelScope.launch {
            _oneShotEvents.send(event)
        }
    }

    data class ViewState(
        val firstName: String = "",
        val lastName: String = "",
        val country: String = "Spain",
        val phoneNumber: String = "",
        val birthdate: String = "",
        val email: String = "",
        val password: String = "",
        val isSignUpButtonClicked: Boolean = false,
        val isPasswordVisible: Boolean = false,
        val isSuccessDialogVisible: Boolean = false
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
        object OnKeyboardDown : ViewEvent
        object NavigateBack : ViewEvent
        object OnDialogCloseClicked : ViewEvent
        object OnDialogEditClicked : ViewEvent
    }

    sealed interface OneShotEvent {
        object ClosePage : OneShotEvent
        object HideKeyboard : OneShotEvent
        object FocusRight : OneShotEvent
        object FocusDown : OneShotEvent
        object FocusClear : OneShotEvent
        object OpenCountryModalSheet : OneShotEvent
        object HideCountryModalSheet : OneShotEvent
    }

    companion object {
        const val MAX_BIRTHDATE_CHAR = 8
        const val MAX_PHONE_NUMBER_CHAR = 9
    }
}