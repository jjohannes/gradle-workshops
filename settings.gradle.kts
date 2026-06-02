pluginManagement {
    includeBuild("gradle/plugins")
}
plugins {
    id("my-settings") version "1.0"
}

dependencyResolutionManagement {
   // versionCatalogs.register("libs") {
   //     from("org.example:mycatalog:1.0")
   // }
}


listOf("model", "game", "engine", "renderer").forEach {
    include(":$it")
    project(":$it").projectDir = file("jamcatch/$it")
}

// include(":model")
// project(":model").projectDir = file("jamcatch/model")
//
// include(":game")
// project(":game").projectDir = file("jamcatch/game")
//
// include(":engine")
// project(":engine").projectDir = file("jamcatch/engine")
//
// include(":renderer")
// project(":renderer").projectDir = file("jamcatch/renderer")
//
// include("jamcatch:renderer")