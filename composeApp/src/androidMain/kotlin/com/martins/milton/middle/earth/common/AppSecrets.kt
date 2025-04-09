package com.martins.milton.middle.earth.common

import com.martins.milton.middle.earth.BuildConfig

actual fun getAppSecrets(): AppSecrets = AppSecrets(
    baseUrl = BuildConfig.baseUrl,
    apiKey = BuildConfig.apiKey
)