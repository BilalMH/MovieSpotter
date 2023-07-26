plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
    id("org.jetbrains.kotlinx.kover")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization")
}

android {
    namespace = "com.bilalhaider.projecttemplate"
    compileSdk = Versions.TARGET_ANDROID_SDK

    defaultConfig {
        applicationId = "com.bilalhaider.projecttemplate"
        minSdk = Versions.MIN_ANDROID_SDK
        targetSdk = Versions.TARGET_ANDROID_SDK
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.COMPOSE_COMPILER
    }

    testOptions {
        unitTests.all {
            it.useJUnitPlatform()
        }
    }

    packagingOptions {
        resources.excludes.add("META-INF/*")
    }
}

dependencies {

    implementation(project(":domain"))

    // Androidx appcompat and core dependencies
    implementation("androidx.appcompat:appcompat:${Versions.Androidx.APP_COMPAT}")
    implementation("androidx.core:core-ktx:${Versions.Androidx.CORE_KTX}")

    // Compose
    implementation("androidx.activity:activity-compose:${Versions.Androidx.ACTIVITY_COMPOSE}")
    implementation("androidx.compose.ui:ui:${Versions.Compose.COMPOSE}")
    implementation("androidx.compose.ui:ui-tooling:${Versions.Compose.COMPOSE}")
    implementation("androidx.compose.foundation:foundation:${Versions.Compose.COMPOSE}")
    implementation("androidx.compose.material:material:${Versions.Compose.COMPOSE}")
    implementation("androidx.compose.material3:material3:${Versions.MATERIAL3}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.Compose.VIEWMODEL_COMPOSE}")
    implementation("io.coil-kt:coil-compose:${Versions.COIL}")

    // Lifecycle dependencies
    implementation("androidx.lifecycle:lifecycle-process:${Versions.Androidx.LIFECYCLE}")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Androidx.LIFECYCLE}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Androidx.LIFECYCLE}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Androidx.LIFECYCLE}")

    // Hilt dependencies
    implementation("com.google.dagger:hilt-android:${Versions.Hilt.HILT}")
    kapt("com.google.dagger:hilt-android-compiler:${Versions.Hilt.HILT}")
    kapt("androidx.hilt:hilt-compiler:${Versions.Hilt.HILT_COMPILER}")

    // Coroutine dependencies
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlinx.COROUTINES}")

    // Testing dependencies
    testImplementation(kotlin("test-junit"))
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${Versions.JUNIT_JUNIPER}")

    testImplementation("org.junit.jupiter:junit-jupiter-api:${Versions.JUNIT_JUNIPER}")

    androidTestImplementation("com.google.truth:truth:${Versions.GOOGLE_TRUTH}")
    androidTestImplementation("androidx.test:runner:${Versions.Androidx.Test.TEST_RUNNER}")
    androidTestImplementation("org.junit.jupiter:junit-jupiter-api:${Versions.JUNIT_JUNIPER}")
    androidTestImplementation("io.mockk:mockk-android:${Versions.MOCKK}")
    androidTestImplementation("io.mockk:mockk-agent:${Versions.MOCKK}")
    androidTestImplementation("android.arch.core:core-testing:${Versions.Androidx.Test.CORE_TESTING}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${Versions.Androidx.Test.ESPRESSO}")
    androidTestImplementation("androidx.test.ext:junit:${Versions.Androidx.Test.JUNIT}")
}