plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("com.autonomousapps.dependency-analysis:com.autonomousapps.dependency-analysis.gradle.plugin:2.13.3")
    implementation("org.gradlex.jvm-dependency-conflict-resolution:org.gradlex.jvm-dependency-conflict-resolution.gradle.plugin:2.1.2")
}
