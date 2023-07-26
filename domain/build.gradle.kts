plugins {
    id("com.android.library")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
    id("org.jetbrains.kotlinx.kover")
    id("com.google.devtools.ksp")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization")
}

android {
    namespace = "com.bilalhaider.projecttemplate.domain"
    compileSdk = Versions.TARGET_ANDROID_SDK

    defaultConfig {
        minSdk = Versions.MIN_ANDROID_SDK
        targetSdk = Versions.TARGET_ANDROID_SDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    testOptions {
        unitTests.all {
            it.useJUnitPlatform()
        }
    }
}

dependencies {

    // Serialization dependencies
    api("org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.Kotlinx.SERIALIZATION}")
    api("org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.Kotlinx.SERIALIZATION}")

    // Coroutine dependencies
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlinx.COROUTINES}")

    // Hilt dependencies
    implementation("com.google.dagger:hilt-android:${Versions.Hilt.HILT}")
    kapt("com.google.dagger:hilt-android-compiler:${Versions.Hilt.HILT}")
    kapt("androidx.hilt:hilt-compiler:${Versions.Hilt.HILT_COMPILER}")

    // Room dependencies
    api("androidx.room:room-runtime:${Versions.Androidx.ROOM}")
    api("androidx.room:room-ktx:${Versions.Androidx.ROOM}")
    kapt("androidx.room:room-ktx:${Versions.Androidx.ROOM}")
    ksp("androidx.room:room-compiler:${Versions.Androidx.ROOM}")

    // Ktor dependencies
    implementation("io.ktor:ktor-client-core:${Versions.KTOR}")
    implementation("io.ktor:ktor-client-android:${Versions.KTOR}")
    implementation("io.ktor:ktor-client-content-negotiation:${Versions.KTOR}")
    implementation("io.ktor:ktor-serialization-kotlinx-json:${Versions.KTOR}")
    implementation("io.ktor:ktor-client-logging:${Versions.KTOR}")
    implementation("io.ktor:ktor-client-mock:${Versions.KTOR}")

    // Testing dependencies
    testImplementation(kotlin("test-junit"))
    testImplementation("com.google.truth:truth:${Versions.GOOGLE_TRUTH}")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.Kotlinx.COROUTINES}")
    testImplementation("io.ktor:ktor-client-mock:${Versions.KTOR}")
    testImplementation("io.mockk:mockk:${Versions.MOCKK}")
    testImplementation("org.junit.jupiter:junit-jupiter-api:${Versions.JUNIT_JUNIPER}")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${Versions.JUNIT_JUNIPER}")
}