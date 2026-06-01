pluginManagement {
    repositories {
        gradlePluginPortal()
        // maven("https://my.org/repo") {
        //     credentials {  }
        // }
    }
    includeBuild("gradle/plugins")
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
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