// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()

    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.4.2")
        classpath("com.codingfeline.buildkonfig:buildkonfig-gradle-plugin:0.11.0")
        classpath("com.google.gms:google-services:4.3.10")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.Hilt.HILT}")
        classpath(kotlin("gradle-plugin", "1.6.10"))
        classpath(kotlin("serialization", "1.6.10"))
    }
}

plugins {
    id("org.jetbrains.kotlinx.kover") version "0.6.1"
    id("com.google.devtools.ksp") version "1.8.10-1.0.9" apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
