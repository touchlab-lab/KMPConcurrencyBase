import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("co.touchlab.native.cocoapods")
    id("com.android.library")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        minSdkVersion(Versions.min_sdk)
        targetSdkVersion(Versions.target_sdk)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

kotlin {
    android()
    //Revert to just ios() when gradle plugin can properly resolve it
    val onPhone = System.getenv("SDK_NAME")?.startsWith("iphoneos")?:false
    if(onPhone){
        iosArm64("ios")
    }else{
        iosX64("ios")
    }
    targets.getByName<KotlinNativeTarget>("ios").compilations["main"].kotlinOptions.freeCompilerArgs +=
        listOf("-Xobjc-generics", "-Xg0")

    version = "1.1"

    sourceSets["commonMain"].dependencies {
        implementation(kotlin("stdlib-common", Versions.kotlin))
    }

    sourceSets["commonTest"].dependencies {
        implementation(Deps.KotlinTest.common)
        implementation(Deps.KotlinTest.annotations)
    }

    sourceSets["androidMain"].dependencies {
        implementation(kotlin("stdlib", Versions.kotlin))
    }

    sourceSets["androidTest"].dependencies {
        implementation(Deps.KotlinTest.jvm)
        implementation(Deps.KotlinTest.junit)
        implementation(Deps.AndroidXTest.core)
        implementation(Deps.AndroidXTest.junit)
        implementation(Deps.AndroidXTest.runner)
        implementation(Deps.AndroidXTest.rules)
        implementation("org.robolectric:robolectric:4.0")
    }

    sourceSets["iosMain"].dependencies {
    }

    cocoapodsext {
        summary = "Common library for the KMP Concurrency Base"
        homepage = "https://github.com/touchlab/KMPConcurrencyBase"
        isStatic = false
    }
}