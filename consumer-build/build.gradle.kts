plugins {
    id("java-library")
}

repositories {
    maven("../test-repo")
    mavenCentral()
}

dependencies {
    api("org.example:core:1.0")
    implementation("com.fasterxml.jackson.core:jackson-databind")
}
