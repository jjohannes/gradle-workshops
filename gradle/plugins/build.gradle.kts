plugins {
    `kotlin-dsl` // id("kotlin-dsl")
    id("maven-publish")
}

group = "org.example"
version = "0.1"

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("org.jetbrains.kotlin.multiplatform:org.jetbrains.kotlin.multiplatform.gradle.plugin:2.3.21")
    implementation("org.gradlex:jvm-dependency-conflict-resolution:2.5")
    implementation("com.autonomousapps:dependency-analysis-gradle-plugin:3.14.0")
}

publishing {
    repositories { maven("../test-repo") { name = "test"} }
}
