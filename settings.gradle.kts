
pluginManagement {
    // repositories.maven("https://example.org/repo")
    repositories.gradlePluginPortal()
    includeBuild("gradle/plugins")
}

include("app")
include("logic")
include("data")

