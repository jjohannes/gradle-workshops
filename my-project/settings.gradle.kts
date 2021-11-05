// Where to get stuff - plugins
pluginManagement {
    // Things to extend Gradle itself (Plugins)
    repositories.gradlePluginPortal()
    includeBuild("my-build-logic")

    // include another plugin from source -> includeBuild("../other-plugin")

    plugins {
        kotlin("jvm") version "3.0"
    }
}

// Where to get stuff - production/test code libraries
dependencyResolutionManagement {
    // Libraries for my product
    repositories.mavenCentral()
    // Your own repository -> repositories.maven {  }
    includeBuild("../some-other-project")
    includeBuild(".") // This allows to use coordinates for project dependencies
}

rootProject.name = "my-project"

include("app")
include("business-logic")
include("data-model")