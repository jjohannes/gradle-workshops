pluginManagement {
    // repositories.gradlePluginPortal()
    includeBuild("gradle/plugins")
}

dependencyResolutionManagement {
    repositories.mavenCentral()
}

rootProject.name = "gradle-workshop-2025"

include(":model")
project(":model").projectDir = file("jamcatch/model")

include(":engine")
project(":engine").projectDir = file("jamcatch/engine")

include(":game")
project(":game").projectDir = file("jamcatch/game")

include(":renderer")
project(":renderer").projectDir = file("jamcatch/renderer")

// Platform / BOM
include(":versions")
project(":versions").projectDir = file("gradle/versions")