import com.exmaple.gradle.CountTask
import java.time.LocalDateTime

plugins {
    id("com.example.java-version")
    id("application")
}

tasks.register<CountTask>("count") {
    group = "example"

    // providers.fileContents(layout.projectDirectory.file("my.config")).asText.get();
    // val gitInfo = providers.exec { commandLine("date") }.standardOutput.asText.get();


    info = "Counting things";
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

