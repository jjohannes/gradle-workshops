plugins {
    `kotlin-dsl` // id("kotlin-dsl")
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.3.21")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:8.6.0")
    implementation("org.gradlex:jvm-dependency-conflict-resolution:2.5")
    implementation("com.autonomousapps:dependency-analysis-gradle-plugin:3.14.0")
}
