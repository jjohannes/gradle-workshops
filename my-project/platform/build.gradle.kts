plugins {
    id("java-platform")
    id("maven-publish")
}

group = "org.example"

dependencies.constraints {
    api(project(":app"))
    api(project(":data-model"))
    api(project(":business-logic"))
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["javaPlatform"])
    }
    repositories.maven("../test-repo")
}
