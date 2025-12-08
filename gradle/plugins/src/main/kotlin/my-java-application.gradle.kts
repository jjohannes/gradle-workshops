plugins {
    id("application")
    id("my-java-compile")
    id("my-dependency-rules")
}

tasks.register<Sync>("bundle") {
    from("build.gradle.kts")

    from(tasks.jar) {
        into("lib")
    }
    // from("build/libs/game.jar")
    // dependsOn(tasks.jar)

    group = "my group"
    description = "Assembles a bundle of the game."
    // archiveFileName = "jam-catch.zip"
}

tasks.register<JarCount>("jarCount") {
    group = "my group"
    jars.from(tasks.jar)
    jars.from(configurations.runtimeClasspath)
    info = "COUNT ==> "
    countOutputFile = layout.buildDirectory.file("count.txt")
}
