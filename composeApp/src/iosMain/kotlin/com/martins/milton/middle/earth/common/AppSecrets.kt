package com.martins.milton.middle.earth.common

import platform.Foundation.NSBundle
import platform.Foundation.NSDictionary
import platform.Foundation.dictionaryWithContentsOfFile

actual fun getAppSecrets(): AppSecrets {
    return AppSecrets(
        baseUrl = getStringResource("baseUrl").orEmpty(),
        apiKey = getStringResource("apiKey").orEmpty()
    )
}

internal fun getStringResource(
    valueKey: String,
    filename: String = "Secrets",
    fileType: String = "plist"
): String? {
    val result = NSBundle.mainBundle.pathForResource(filename, fileType)?.let {
        val map = NSDictionary.dictionaryWithContentsOfFile(it)
        map?.get(valueKey) as? String
    }
    return result
}