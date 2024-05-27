plugins {
    id("java")
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

// tasks.register()