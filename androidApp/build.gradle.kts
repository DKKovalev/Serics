plugins {
    id("com.android.application")
    kotlin("android")
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:${properties["version.material"]}")
    implementation("androidx.appcompat:appcompat:${properties["version.appcompat"]}")
    implementation("androidx.constraintlayout:constraintlayout:${properties["version.constraint"]}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${properties["version.coroutines"]}")
    implementation("com.github.aakira:napier:${properties["version.napier"]}")
    implementation("org.kodein.di:kodein-di-framework-android-x:${properties["version.kodein"]}")
}

android {
    compileSdkVersion((properties["version.compileSdk"].toString()).toInt())
    defaultConfig {
        applicationId = "ru.dkkovalev.serics.androidApp"
        minSdkVersion((properties["version.minSdk"].toString()).toInt())
        targetSdkVersion((properties["version.compileSdk"].toString()).toInt())
        versionCode = (properties["version.code"].toString()).toInt()
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}