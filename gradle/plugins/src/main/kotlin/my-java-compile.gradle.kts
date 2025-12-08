plugins {
    id("java")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

tasks.compileJava {
    options.compilerArgs.add("-Werror")
    options.compilerArgs.add("-Xlint:all,-serial")
}
