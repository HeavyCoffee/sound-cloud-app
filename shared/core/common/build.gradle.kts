plugins {
    alias(libs.plugins.buildlogic.kmp.library)
    alias(libs.plugins.buildlogic.kmp.di)
}

kotlin {
    android {
        buildFeatures { buildConfig = true }
    }
}