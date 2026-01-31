package com.soundloud.core.network.di

import com.soundloud.core.common.system.AppBuildInfo
import com.soundloud.core.network.ApiConfig
import com.soundloud.core.network.HttpClientFactory
import com.soundloud.core.common.system.BuildType
import io.ktor.client.HttpClient
import io.ktor.http.HttpHeaders
import org.koin.dsl.module

val koinNetworkModule = module {
    single<ApiConfig> {
        when(get<AppBuildInfo>().buildType) {
            BuildType.DEBUG,
            BuildType.RELEASE -> ApiConfig.getReleaseConfig()
        }
    }
    single<HttpClient> {
        HttpClient(
            HttpClientFactory(
                baseUrl = get<ApiConfig>().baseUrl,
                headers = mapOf(HttpHeaders.Accept to "application/json; charset=utf-8"),
                bearerProvider = getOrNull()
            )
        )
    }
}