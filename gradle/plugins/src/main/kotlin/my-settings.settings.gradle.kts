pluginManagement {
    repositories {
        gradlePluginPortal()
        // maven("https://my.org/repo") {
        //     credentials {  }
        // }
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven("jamcatch/test-repo")
    }
}