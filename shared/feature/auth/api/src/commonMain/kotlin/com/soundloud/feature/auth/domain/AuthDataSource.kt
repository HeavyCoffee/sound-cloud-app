package com.soundloud.feature.auth.domain

import com.soundloud.feature.auth.domain.model.AuthTokens

interface AuthDataSource {
    suspend fun getAuthUrl(): String
    suspend fun refreshToken(refreshToken: String): AuthTokens
}