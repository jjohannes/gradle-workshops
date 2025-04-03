pluginManagement {
    includeBuild("gradle/plugins")
    // includeBuild("../own-gradle-plugins")
    repositories {
        // maven("https://example.org/repo")
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
    // includeBuild("../framework")
    versionCatalogs {
        // create("libs") {
        //     from("org.example:catalog:1.0")
        // }
    }
}

include("app")
include("logic")
include("data")
