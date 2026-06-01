plugins {
    `kotlin-dsl` // id("kotlin-dsl")
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("org.jetbrains.kotlin.multiplatform:org.jetbrains.kotlin.multiplatform.gradle.plugin:2.3.21")
    implementation("org.gradlex:jvm-dependency-conflict-resolution:2.5")
}
