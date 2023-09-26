
pluginManagement {
    repositories {
        gradlePluginPortal()
    }
    includeBuild("gradle/plugins")
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        // maven("local-repo")
        // maven("https://example.org/repo")
    }
    // includeBuild("..")
}


include(":app")
include(":business-logic")
include(":data-model")
