plugins {
    id("java-library")
    id("maven-publish")
}

group = "org.example"
version = "1.0"

val meta = configurations.create("meta")

dependencies {
    api(platform(project(":platform")))

    implementation("org.apache.commons:commons-text")

    meta(platform("org.example:platform:1.0"))
    meta("org.apache.commons:commons-text")
}

publishing {
    publications.create<MavenPublication>("maven") {
        // versionMapping {
        //     allVariants {
        //         fromResolutionResult()
        //     }
        // }
        from(components["java"])
    }
    repositories {
        maven("../test-repo")
    }
}