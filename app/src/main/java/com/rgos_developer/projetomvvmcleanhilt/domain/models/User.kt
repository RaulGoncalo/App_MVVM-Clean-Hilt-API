package com.rgos_developer.projetomvvmcleanhilt.domain.models

import com.rgos_developer.projetomvvmcleanhilt.presentation.models.UserPresentation

data class User(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val email: String,
    val phone: String,
    val image: String
)

fun User.toUserPresentation() : UserPresentation {
    return UserPresentation(
        firstName = this.firstName,
        lastName = this.lastName,
        age = this.age,
        email = this.email,
        phone = this.phone,
        image = this.image
    )
}
