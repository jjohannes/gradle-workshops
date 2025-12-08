plugins {
    id("java-library")
}

dependencies {
    implementation(project(":model"))
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}
