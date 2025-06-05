package com.martins.milton.middle.earth.common

import platform.Foundation.NSURL
import platform.UIKit.UIApplication

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class BrowserTab {
    actual fun open(url: String) {
        val website = NSURL(string = url)
        if (UIApplication.sharedApplication().canOpenURL(website)) {
            UIApplication.sharedApplication().openURL(
                url = website,
                options = mapOf<Any?, Any>(),
                completionHandler = {}
            )
        }
    }
}