plugins {
    alias(libs.plugins.buildlogic.kmp.library)
    alias(libs.plugins.buildlogic.kmp.di)
    alias(libs.plugins.buildlogic.compose)
    alias(libs.plugins.kotlin.serializationPlugin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.navMenu.api)
            implementation(projects.shared.core.ui)
        }
    }
}