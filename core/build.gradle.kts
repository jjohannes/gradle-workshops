plugins {
    id("java-library")
    id("maven-publish")
}

group = "org.example"
version = "1.0"

dependencies {
    api(platform("org.example:platform"))

    implementation("org.apache.commons:commons-text")
}

publishing {
    publications.create<MavenPublication>("maven") {
        versionMapping {
            allVariants {
                fromResolutionResult()
            }
        }
        from(components["java"])
    }
    repositories {
        maven("../test-repo")
    }
}