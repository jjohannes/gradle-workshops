import com.exmaple.gradle.CountTask

plugins {
    id("com.example.java-version")
    id("application")
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}
tasks.compileJava {
    options.encoding = "UTF-8"
}
tasks.compileTestJava {
    options.encoding = "UTF-8"
}

tasks.register<CountTask>("count") {
    group = "example"

    // onlyIf {  }

    // providers.fileContents(layout.projectDirectory.file("my.config")).asText.get();
    // val gitInfo = providers.exec { commandLine("date") }.standardOutput.asText.get();

    info = tasks.jar.flatMap { it.archiveFileName }
    filesToCount.from(configurations.runtimeClasspath)
    filesToCount.from(tasks.jar)

    countFile = layout.buildDirectory.file("count.txt")
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

