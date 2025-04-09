package com.martins.milton.middle.earth.common

data class AppSecrets(
    val baseUrl: String,
    val apiKey: String
)

expect fun getAppSecrets(): AppSecrets