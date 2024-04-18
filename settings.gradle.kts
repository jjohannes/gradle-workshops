pluginManagement {
    repositories {
        gradlePluginPortal()
    }
    includeBuild("gradle/plugins")
}


include("app")
include("business-logic")
include("data-model")
