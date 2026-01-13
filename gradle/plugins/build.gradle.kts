plugins {
    `kotlin-dsl` // id("kotlin-dsl")
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("com.diffplug.spotless:spotless-plugin-gradle:8.1.0")
    implementation("org.gradlex:jvm-dependency-conflict-resolution:2.5")
    implementation("io.mvnpm.gradle.plugin:native-java-plugin:1.0.0")
    implementation("com.autonomousapps:dependency-analysis-gradle-plugin:3.5.1")
}
