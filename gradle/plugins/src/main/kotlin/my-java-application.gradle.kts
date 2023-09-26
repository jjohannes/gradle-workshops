import org.example.tasks.CountFiles

plugins {
    id("application")
    id("my-java-base")
}

tasks.register<CountFiles>("count") {
    group = "my group"

    filesToCount.from(configurations.runtimeClasspath)

    countFile.set(layout.buildDirectory.file("numberOfFiles.txt"))
}

tasks.register<Zip>("bundle") {
    group = "my group"

    // dependsOn(tasks.jar)

    from(tasks.jar)
    from(tasks.named("count"))
    from(configurations.runtimeClasspath)
    from(layout.projectDirectory.file("version.txt"))

    destinationDirectory.set(layout.buildDirectory.dir("bundle"))
}
