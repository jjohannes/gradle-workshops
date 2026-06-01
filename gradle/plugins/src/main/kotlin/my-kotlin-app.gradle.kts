plugins {
    id("my-kotlin-library")
}

kotlin {
    jvm { mainRun { mainClass = "org.example.jamcatch.game.GameAppKt" } }
}

// tasks.named<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>("compileKotlinJvm") {
//     javaPackagePrefix = "xxxx"
// }

// Configure existing task
tasks.named<Jar>("jvmJar") {
    from("build.gradle.kts")

    manifest {

    }
}

// Register task with existing type
// tasks.create("bundle") <-- old API
tasks.register<Zip>("bundle") {
    group = "package"

    from(layout.projectDirectory.file("build.gradle.kts"))

    // from(layout.buildDirectory.file("libs/game-jvm.jar"))
    // dependsOn(tasks.named("jvmJar"))

    from(tasks.named<Jar>("jvmJar").flatMap { it.archiveFile })
}


tasks.register<PrintFileName>("printFileName") {
    group = "package"
    fileToPrint = tasks.named<Jar>("jvmJar")
        .flatMap { it.archiveFile }
    outFile = layout.buildDirectory.file("fileName.txt")
    projectName = project.name
}
