package com.akole.signupcompose.model

data class User (
    val firstName: String,
    val lastName: String,
    val phoneNumber: String?,
    val country: String,
    val birthdate: String
    )
