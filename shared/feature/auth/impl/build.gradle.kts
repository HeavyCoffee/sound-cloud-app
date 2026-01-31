plugins {
    alias(libs.plugins.buildlogic.kmp.library)
    alias(libs.plugins.buildlogic.kmp.di)
    alias(libs.plugins.buildlogic.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.core.decompose)
            implementation(projects.shared.feature.auth.api)
            implementation(projects.shared.core.ui)
        }
    }
}