plugins {
    id("java")
    id("org.gradlex.jvm-dependency-conflict-resolution")
    id("com.diffplug.spotless")
    id("com.autonomousapps.dependency-analysis")
}

// configure compilation
java {
    toolchain.languageVersion = JavaLanguageVersion.of(21)
}

tasks.compileJava {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-Xlint:all")
}

// configure testing
tasks.test {
    useJUnitPlatform()
}

// configure code formatting
spotless {
    java { palantirJavaFormat() }
}
