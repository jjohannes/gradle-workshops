
// Where to get stuff
pluginManagement {
    // Things to extend Gradle itself (Plugins)
    repositories.gradlePluginPortal()
    includeBuild("my-build-logic")

    plugins {
        kotlin("jvm") version "3.0"
    }
}


dependencyResolutionManagement {
    // Libraries for my product
    repositories.mavenCentral()
    // repositories.maven {  }
    includeBuild("../some-other-project")
    includeBuild(".") // This allows to use coordinates for project dependencies
}

rootProject.name = "my-project"

include("app")
include("business-logic")
include("data-model")