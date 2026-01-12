plugins {
    `kotlin-dsl` // id("kotlin-dsl")
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("com.diffplug.spotless:spotless-plugin-gradle:8.1.0")
}
