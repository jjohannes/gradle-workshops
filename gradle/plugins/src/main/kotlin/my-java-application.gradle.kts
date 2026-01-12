plugins {
    id("application")
    id("java-compilation")
}

application {
    mainClass = "org.example.jamcatch.game.GameApp"
}

// OLD SYNTAX:
//
// task bundle(Zip) {
//
// }
// tasks.create("bundle", Zip::class) {
//     from("build.gradle.kts")
// }


// https://docs.gradle.org/current/userguide/working_with_files.html
// tasks.register("bundle", Sync::class) {
tasks.register("bundle", Zip::class) {
    group = "my"
    description = "Assembles a Bundle"

    // dependsOn(tasks.jar)
    // from("build/libs/game.jar")
    into("libs") {
        from(tasks.jar)
        from(configurations.runtimeClasspath)
    }
    from("build.gradle.kts")
    // destinationDir = layout.buildDirectory.dir("bundle_dir").get().asFile
    destinationDirectory = layout.buildDirectory.dir("bundle")
}

tasks.register("countJars", JarCount::class) {
    group = "my"
    header = "Counting:"
    filesToCount.from(tasks.jar)
    filesToCount.from(configurations.runtimeClasspath)
    countTextFile = layout.buildDirectory.file("count.txt")
}
