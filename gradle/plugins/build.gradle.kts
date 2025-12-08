plugins {
    `kotlin-dsl` // id("kotlin-dsl")
}

repositories.gradlePluginPortal()

dependencies {
    implementation("org.gradlex:jvm-dependency-conflict-resolution:2.5")
    implementation("io.mvnpm.gradle.plugin:native-java-plugin:1.0.0")
}
