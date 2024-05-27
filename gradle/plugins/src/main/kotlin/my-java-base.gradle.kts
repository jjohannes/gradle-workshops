plugins {
    id("java")
}

val qualityCheck = tasks.register("qualityCheck") {
    group = "build"
    dependsOn(tasks.jar)
    // dependsOn("")
}

tasks.jar {
    setGroup(null)
}

tasks.check {
    dependsOn(tasks.assemble)
    dependsOn(qualityCheck)
}


java {
    toolchain.languageVersion = JavaLanguageVersion.of(21)
}

// Discover task type: ./gradlew help --task compileJava
tasks.compileJava {
    options.encoding = "UTF-8"
}
// Same as above
tasks.named<JavaCompile>("compileJava") {
    options.encoding = "UTF-8"
}
tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

sourceSets.main {
    resources {
        // include()
    }
}

tasks.processResources {
    from("build.gradle.kts")
}