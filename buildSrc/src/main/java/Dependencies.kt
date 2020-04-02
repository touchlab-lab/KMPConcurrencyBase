import org.gradle.api.artifacts.ExternalModuleDependency
import org.gradle.kotlin.dsl.exclude

object Versions {
    val min_sdk = 21
    val target_sdk = 29
    val compile_sdk = 29

    val kotlin = "1.3.61"
    val android_x = "1.1.0"
    val android_gradle_plugin = "3.4.1"
    val buildToolsVersion = "29.0.0"
    val junit = "4.12"
    val cocoapodsext = "0.6"
}

object Deps {
    val app_compat_x = "androidx.appcompat:appcompat:${Versions.android_x}"
    val material_x = "com.google.android.material:material:${Versions.android_x}"
    val core_ktx = "androidx.core:core-ktx:${Versions.android_x}"
    val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.android_x}"
    val android_gradle_plugin = "com.android.tools.build:gradle:${Versions.android_gradle_plugin}"
    val junit = "junit:junit:${Versions.junit}"
    val cocoapodsext = "co.touchlab:kotlinnativecocoapods:${Versions.cocoapodsext}"

    object AndroidXTest {
        val core =  "androidx.test:core:${Versions.android_x}"
        val junit =  "androidx.test.ext:junit:${Versions.android_x}"
        val runner = "androidx.test:runner:${Versions.android_x}"
        val rules = "androidx.test:rules:${Versions.android_x}"
    }

    object KotlinTest {
        val common =      "org.jetbrains.kotlin:kotlin-test-common:${Versions.kotlin}"
        val annotations = "org.jetbrains.kotlin:kotlin-test-annotations-common:${Versions.kotlin}"
        val jvm =         "org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}"
        val junit =       "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
    }
}
