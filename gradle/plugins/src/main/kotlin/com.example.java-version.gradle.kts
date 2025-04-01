plugins {
    id("java")
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(17)
}

tasks.withType<JavaCompile>().configureEach {
    options.forkOptions.memoryMaximumSize = "2g"
}

tasks.test {
    maxHeapSize = "1g"
}

// Lifecycle task
tasks.assemble {
    dependsOn(tasks.compileTestJava)
}