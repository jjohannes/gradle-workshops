plugins {
    id("java")
    id("com.diffplug.spotless")
}

spotless {
    java { palantirJavaFormat() }
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(21)
}

tasks.compileJava { // == tasks.named("compileJava")
    options.encoding = "UTF-8"
    options.compilerArgs.add("-Xlint:all")
}
