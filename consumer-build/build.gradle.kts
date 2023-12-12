plugins {
    id("java-library")
}

val metaClasspath = configurations.create("metaClasspath") {
    isCanBeConsumed = false
    isCanBeResolved = true

    // extendsFrom(configurations.implementation)

    attributes {
        attribute(Usage.USAGE_ATTRIBUTE, objects.named("meta"))
    }
}

dependencies {
    api("org.example:core:1.0")
    implementation("com.fasterxml.jackson.core:jackson-databind")

    metaClasspath("org.example:core:1.0")
}

tasks.register("printMeta") {
    doLast {
        println(metaClasspath.files)
    }
}

repositories {
    maven("../test-repo")
    mavenCentral()
}
