package com.martins.milton.middle.earth.di.module

import com.martins.milton.middle.earth.common.BrowserTab
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val platformModule: Module = module {
    singleOf(::BrowserTab)
}