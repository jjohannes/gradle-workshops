plugins {
    id("lifecycle-base")
    id("application")
    id("my-java-base")
}

val pack = tasks.register<Zip>("package") {
    group = "my"
    description = "packages application"

    from("build.gradle.kts")

    destinationDirectory = layout.buildDirectory.dir("package")
}

tasks.assemble {
    dependsOn(pack)
}


tasks.jar {
    from(pack)
}
