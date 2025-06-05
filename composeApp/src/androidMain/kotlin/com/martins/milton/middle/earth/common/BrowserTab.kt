package com.martins.milton.middle.earth.common

import android.content.Context
import android.content.Intent
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.net.toUri

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class BrowserTab(
    private val context: Context
) {
    actual fun open(url: String) {
        val customTabsIntent = CustomTabsIntent.Builder().build().apply {
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        customTabsIntent.launchUrl(
            context,
            url.toUri()
        )
    }
}
