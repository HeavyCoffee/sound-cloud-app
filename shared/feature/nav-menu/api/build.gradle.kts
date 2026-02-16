plugins {
    alias(libs.plugins.buildlogic.kmp.library)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.core.decompose)
        }
    }
}