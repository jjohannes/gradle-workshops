plugins {
    id("my-kmp-app")
}

dependencies {
    commonMainImplementation(project(":model"))
    commonMainImplementation(project(":engine"))
    commonMainImplementation("org.apache.commons:commons-csv:1.14.1")
    commonMainImplementation("commons-io:commons-io:2.20.0")
    commonMainImplementation("org.slf4j:slf4j-api:2.0.17")

    commonMainRuntimeOnly(project(":renderer"))
    commonMainRuntimeOnly("org.slf4j:slf4j-simple:2.0.17")
}

kotlin {
    @OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
    jvm { mainRun { mainClass = "org.example.jamcatch.game.GameAppKt" } }
}
