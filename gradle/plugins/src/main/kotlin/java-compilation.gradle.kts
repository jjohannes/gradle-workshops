plugins {
    id("java")
    id("com.diffplug.spotless")
    id("org.gradlex.jvm-dependency-conflict-resolution")
    id("io.mvnpm.gradle.plugin.native-java-plugin")
    id("com.autonomousapps.dependency-analysis")
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

tasks.test {
    useJUnitPlatform()
}
