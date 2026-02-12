import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING
import org.jetbrains.compose.internal.utils.localPropertiesFile
import java.util.Properties

plugins {
    alias(libs.plugins.buildlogic.kmp.library)
    alias(libs.plugins.buildlogic.kmp.di)
    alias(libs.plugins.buildlogic.compose)
    alias(libs.plugins.build.konfig)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.core.decompose)
            implementation(projects.shared.feature.auth.api)
            implementation(projects.shared.core.ui)
            implementation(projects.shared.core.network)
        }
    }
}

buildkonfig {
    packageName = "com.soundloud.feature.auth"
    objectName = "ClientConfig"

    val properties = Properties()
    file(localPropertiesFile).inputStream().use { properties.load(it) }

    defaultConfigs {
        val clientId = "client_id"
        buildConfigField(
            STRING,
            clientId,
            properties.getProperty(clientId) ?: System.getenv(clientId)
        )

        val clientSecret = "client_secret"
        buildConfigField(
            STRING,
            clientSecret,
            properties.getProperty(clientSecret) ?: System.getenv(clientSecret)
        )
    }
}