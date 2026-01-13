plugins {
    id("java")
    id("com.diffplug.spotless")
    id("org.gradlex.jvm-dependency-conflict-resolution")
    id("io.mvnpm.gradle.plugin.native-java-plugin")
    id("com.autonomousapps.dependency-analysis")
}

// configure compilation
java {
    toolchain.languageVersion = JavaLanguageVersion.of(21)
}

tasks.compileJava { // == tasks.named("compileJava")
    options.encoding = "UTF-8"
    options.compilerArgs.add("-Xlint:all")
}

// configure testing
tasks.test {
    useJUnitPlatform()
}

// configure code formatting
spotless {
    java {
        palantirJavaFormat()
    }
}
