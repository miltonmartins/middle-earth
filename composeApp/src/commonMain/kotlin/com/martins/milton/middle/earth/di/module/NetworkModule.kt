package com.martins.milton.middle.earth.di.module

import com.martins.milton.middle.earth.common.getAppSecrets
import io.ktor.client.*
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.dsl.module

val ktorModule: Module = module {
    single { client }
}

private val appSecrets = getAppSecrets()

private val client = HttpClient {
    defaultRequest {
        url(appSecrets.baseUrl)
    }
    install(Auth) {
        bearer {
            loadTokens {
                BearerTokens(
                    accessToken = appSecrets.apiKey,
                    refreshToken = null
                )
            }
        }
    }
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        })
    }
    install(Logging) {
        logger = Logger.DEFAULT
        level = LogLevel.ALL
        sanitizeHeader { header -> header == HttpHeaders.Authorization }
    }
}