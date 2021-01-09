import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization") version "1.4.10"
    id("com.android.library")
}

kotlin {
    android()
    ios {
        binaries {
            framework {
                baseName = "shared"
                export("com.russhwolf:multiplatform-settings-no-arg:${properties["version.multiplatformSettings"]}")
                transitiveExport = true
            }
        }
    }

    @Suppress("UNUSED_VARIABLE") sourceSets {
        val commonMain by getting {
            dependencies {
                //Coroutines
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${properties["version.coroutines"]}")

                //Networking
                implementation("io.ktor:ktor-client-core:${properties["version.ktor"]}")
                implementation("io.ktor:ktor-client-serialization:${properties["version.ktor"]}")
                implementation("io.ktor:ktor-client-cio:${properties["version.ktor"]}")
                implementation("io.ktor:ktor-client-logging:${properties["version.ktor"]}")

                //Logging
                implementation("com.github.aakira:napier:${properties["version.napier"]}")

                //Shared Preferences
                api("com.russhwolf:multiplatform-settings-no-arg:${properties["version.multiplatformSettings"]}")

                //DI
                implementation("org.kodein.di:kodein-di:${properties["version.kodein"]}")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-android:${properties["version.ktor"]}")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${properties["version.coroutines"]}")
                implementation("com.google.android.material:material:1.2.1")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13")
            }
        }
        val iosMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-ios:${properties["version.ktor"]}")
            }
        }
        val iosTest by getting
    }
}

android {
    compileSdkVersion(29)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(29)
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

val packForXcode by tasks.creating(Sync::class) {
    group = "build"
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val sdkName = System.getenv("SDK_NAME") ?: "iphonesimulator"
    val targetName = "ios" + if (sdkName.startsWith("iphoneos")) "Arm64" else "X64"
    val framework =
        kotlin.targets.getByName<KotlinNativeTarget>(targetName).binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)
}

tasks.getByName("build").dependsOn(packForXcode)