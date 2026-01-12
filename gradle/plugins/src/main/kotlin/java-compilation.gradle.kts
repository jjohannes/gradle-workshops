plugins {
    id("java")
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(21)
}

tasks.compileJava {
    options.encoding = "UTF-8"
}
