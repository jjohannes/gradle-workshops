plugins {
    id("com.example.java-version")
    id("application")
}

tasks.register<Zip>("bundle") {
    group = "example"
    description = "Bundles the application"

    from(tasks.jar)
    // from("build/libs/app.jar")
    // dependsOn(tasks.jar)

    from(layout.projectDirectory.file("../gradle.properties"))
    from(layout.projectDirectory.file("../gradlew"))

    destinationDirectory = layout.buildDirectory.dir("bundled")
}

// Configure an existing task
tasks.named<JavaCompile>("compileJava") { }
tasks.compileJava { }

// layout.buildDirectory.set(layout.projectDirectory.dir("out"))

