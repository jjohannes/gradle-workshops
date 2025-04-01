plugins {
    id("java")
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(17)
}

// Lifecycle task
tasks.assemble {
    dependsOn(tasks.compileTestJava)
}