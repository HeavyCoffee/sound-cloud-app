package com.soundloud.feature.auth.impl.data

import com.soundloud.feature.auth.domain.AuthDataSource
import com.soundloud.feature.auth.domain.model.AuthTokens

class AuthDataSourceImpl : AuthDataSource {
    override suspend fun getAuthUrl(): String {
        TODO("Not yet implemented")
    }

    override suspend fun refreshToken(refreshToken: String): AuthTokens {
        TODO("Not yet implemented")
    }
}