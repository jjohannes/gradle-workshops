pluginManagement {
    // repositories.maven("https://example.org/repo")
    repositories.gradlePluginPortal()
    includeBuild("gradle/plugins")
}

dependencyResolutionManagement {
    repositories.mavenCentral() {
        mavenContent {
            excludeGroup("org.example")
        }
    }
    repositories.maven("https://example.org/repo2")
}

include("app")
include("logic")
include("data")

