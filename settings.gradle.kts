pluginManagement {
    includeBuild("gradle/plugins")
    repositories {

    }
}
// plugins {
//     id("org.example.build")
// }

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        // maven("https://example.org/repo")
    }
    versionCatalogs {
        // create("libs") {
        //     from("org.example:catalog:1.0")
        // }
    }
}

include("app")
include("logic")
include("data")
