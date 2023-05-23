import kotlin.io.path.toPath

// Where to get stuff - plugins
pluginManagement {
    // Things to extend Gradle itself (Plugins)
    repositories.gradlePluginPortal()
    includeBuild("gradle/plugins")
    // include another plugin from source -> includeBuild("../other-plugin")
}

dependencyResolutionManagement {
    repositories.mavenCentral()
}

// includeBuild("../some-other-project")

/*
    // Libraries for my product
    repositories.mavenCentral()
    // Your own repository -> repositories.maven {  }
    // includeBuild("../some-other-project")
    includeBuild(".") // This allows to use coordinates for project dependencies
*/

rootProject.name = "my-project"

include("platform")
include("app")
include("business-logic")
include("data-model")