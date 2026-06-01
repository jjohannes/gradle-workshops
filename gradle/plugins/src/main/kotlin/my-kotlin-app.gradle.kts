plugins {
    id("my-kotlin-library")
}

kotlin {
    jvm { mainRun { mainClass = "org.example.jamcatch.game.GameAppKt" } }
}

// tasks.named<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>("compileKotlinJvm") {
//     javaPackagePrefix = "xxxx"
// }

// tasks.create("bundle") <-- old API

tasks.register<Zip>("bundle") {
    from(layout.projectDirectory.file("build.gradle.kts"))

    // from(layout.buildDirectory.file("libs/game-jvm.jar"))
    // dependsOn(tasks.named("jvmJar"))

    from(tasks.named<Jar>("jvmJar").flatMap { it.archiveFile });
    group = "package"
}

tasks.named<Jar>("jvmJar") {
    from("build.gradle.kts")

    manifest {

    }
}
