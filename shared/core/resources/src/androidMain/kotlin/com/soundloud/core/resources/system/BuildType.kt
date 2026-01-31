package com.soundloud.core.common.system

import com.soundloud.shared.core.common.BuildConfig

internal actual fun getBuildType(): BuildType =
    if (BuildConfig.DEBUG) BuildType.DEBUG else BuildType.RELEASE