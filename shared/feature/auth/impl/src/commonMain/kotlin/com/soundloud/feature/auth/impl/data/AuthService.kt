package com.soundloud.feature.auth.impl.data

import io.ktor.client.HttpClient

internal interface AuthService {

}

internal class AuthServiceImpl(
    private val client: HttpClient
) : AuthService {

}