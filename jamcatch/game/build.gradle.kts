plugins {
    id("application")
    id("org.gradlex.jvm-dependency-conflict-resolution") version "2.5"
    id("io.mvnpm.gradle.plugin.native-java-plugin") version "1.0.0"
}

dependencies {
    implementation(project(":model"))
    implementation(project(":engine"))
    implementation("org.apache.commons:commons-csv:1.14.1")
    implementation("org.slf4j:slf4j-api:2.0.17")

    runtimeOnly(project(":renderer"))
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

application {
    mainClass = "org.example.jamcatch.game.GameApp"
}