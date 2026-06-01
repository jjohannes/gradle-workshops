pluginManagement {
    repositories {
        gradlePluginPortal()
    }
    includeBuild("../../gradle/plugins")
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}