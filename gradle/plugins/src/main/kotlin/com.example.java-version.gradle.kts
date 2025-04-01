import org.gradle.jvm.toolchain.JavaLanguageVersion

plugins {
    id("java")
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(17)
}