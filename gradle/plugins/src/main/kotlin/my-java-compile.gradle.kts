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

testing {
    suites {
        named<JvmTestSuite>("test") {
            useJUnitJupiter()
        }
        register<JvmTestSuite>("xtest")
    }
}

tasks.test {
    maxParallelForks = 100
    maxHeapSize = "1g"
}
