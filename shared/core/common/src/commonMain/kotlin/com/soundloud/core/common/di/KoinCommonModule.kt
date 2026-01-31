package com.soundloud.core.common.di

import com.soundloud.core.common.system.AppBuildInfo
import com.soundloud.core.common.system.getBuildType
import com.soundloud.core.common.system.getDeviceInfo
import org.koin.dsl.module

val koinCommonModule = module {
    single<AppBuildInfo> {
        AppBuildInfo(
            buildType = getBuildType(),
            deviceInfo = getDeviceInfo()
        )
    }
}