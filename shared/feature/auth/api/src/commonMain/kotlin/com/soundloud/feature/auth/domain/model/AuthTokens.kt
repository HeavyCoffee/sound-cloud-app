package com.soundloud.feature.auth.domain.model

data class AuthTokens(
    val access: String,
    val refresh: String
)