package com.soundloud.app.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

object DI {
    fun start(appDeclaration: KoinAppDeclaration = {}) = startKoin {
        appDeclaration()
        modules(coreModules() + featureModules())
    }

    fun start() = start {}
}