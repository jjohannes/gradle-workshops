plugins {
    id("java-platform")
    id("maven-publish")
}

group = "org.example"
version = "1.0"

javaPlatform.allowDependencies()

dependencies {
    api(platform("com.fasterxml.jackson:jackson-bom:2.15.3"))
}

dependencies.constraints {
    api("org.apache.commons:commons-text:1.11.0")
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["javaPlatform"])
    }
    repositories {
        maven("../test-repo")
    }
}