pluginManagement {
    includeBuild("gradle/plugins")
    repositories {

    }
}
dependencyResolutionManagement {
    repositories {
        mavenCentral()
        // maven("https://example.org/repo")
    }
}

include("app")
include("logic")
include("data")
