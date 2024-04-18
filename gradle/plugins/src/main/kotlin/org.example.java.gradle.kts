plugins {
    id("java")
}

version = "1.0"
group = "org.example"

java {
    toolchain.languageVersion = JavaLanguageVersion.of(21)
}

tasks.compileJava {
    options.encoding = "UTF-8"
}

tasks.compileTestJava {
    options.encoding = "UTF-8"
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

tasks.register<Copy>("copyToTarget") {
    group = "my"
    from(tasks.jar)
    from(layout.projectDirectory.file("build.gradle.kts"))
    into(layout.buildDirectory.dir("target"))
}



