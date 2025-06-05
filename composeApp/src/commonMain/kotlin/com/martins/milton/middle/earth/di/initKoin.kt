package com.martins.milton.middle.earth.di

import com.martins.milton.middle.earth.di.module.ktorModule
import com.martins.milton.middle.earth.di.module.platformModule
import com.martins.milton.middle.earth.di.module.sharedAppModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            sharedAppModule,
            ktorModule,
            platformModule
        )
    }
}