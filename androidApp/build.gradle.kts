plugins {
    id("com.android.application")
    kotlin("android")
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.2.1")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${properties["version.coroutines"]}")
    implementation("com.github.aakira:napier:${properties["version.napier"]}")
    implementation("com.russhwolf:multiplatform-settings:${properties["version.multiplatformSettings"]}")
}

android {
    compileSdkVersion(29)
    defaultConfig {
        applicationId = "ru.dkkovalev.serics.androidApp"
        minSdkVersion(24)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}