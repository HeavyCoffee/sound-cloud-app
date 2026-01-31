plugins {
    alias(libs.plugins.buildlogic.android.app)
    alias(libs.plugins.buildlogic.compose)
}

dependencies {
    implementation(projects.shared.app)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.android)
}