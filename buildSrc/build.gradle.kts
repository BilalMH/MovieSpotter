plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation("com.android.tools.build:gradle:7.4.2")
    implementation("org.ajoberstar.grgit:grgit-core:5.0.0")
    implementation("com.squareup:javapoet:1.13.0")
    implementation(kotlin("compiler-embeddable", "1.6.10"))
    implementation(kotlin("gradle-plugin", "1.8.10"))
}