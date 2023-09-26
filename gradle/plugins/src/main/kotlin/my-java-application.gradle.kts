plugins {
    id("application")
    id("my-java-base")
}

tasks.register<Zip>("bundle") {
    group = "my group"

    // dependsOn(tasks.jar)

    from(tasks.jar)
    from(configurations.runtimeClasspath)
    from(layout.projectDirectory.file("version.txt"))

    destinationDirectory.set(layout.buildDirectory.dir("bundle"))
}
