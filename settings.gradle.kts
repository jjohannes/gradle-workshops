dependencyResolutionManagement {
    repositories.mavenCentral()
}

include(":model")
project(":model").projectDir = file("jamcatch/model")

include(":engine")
project(":engine").projectDir = file("jamcatch/engine")

include(":game")
project(":game").projectDir = file("jamcatch/game")

include(":renderer")
project(":renderer").projectDir = file("jamcatch/renderer")