import org.gradle.api.JavaVersion
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

internal object AndroidConfig {
    const val BASE_NAME_SPACE: String = "com.soundloud"
    const val APP_ID: String = "com.heavycoffee.soundloud"
    const val VERSION_NAME: String = "0.0.1"
    val JAVA_TARGET: JvmTarget = JvmTarget.JVM_17
    val JAVA_VERSION: JavaVersion = JavaVersion.VERSION_17
}