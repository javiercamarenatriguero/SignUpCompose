package com.akole.signupcompose.utils

import android.util.Patterns
import java.util.regex.Pattern

fun String.isValidEmail(): Boolean =
    Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun String.isValidPhoneNumber(): Boolean =
    Pattern.matches(PHONE_REGEX, this)

fun String.isValidDate(): Boolean =
    Pattern.matches(DATE_REGEX, this)

fun String.isValidPassword(): Boolean =
    Pattern.matches(PASSWORD_REGEX, this)

private const val DATE_REGEX = "^(0?[1-9]|[12][0-9]|3[01])(0?[1-9]|1[012])((19|20)\\d\\d)$"
private const val PASSWORD_REGEX = "^\\w{7,14}\$"
// TODO @jcamarena Use a generic Phone Regex. It would be nice applying different once for each selected country
private const val PHONE_REGEX = "^\\d{9}\$"

