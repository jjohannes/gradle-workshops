plugins {
    // id("java")
    id("application")
}

application {
    mainClass = "com.example.app.App"
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(17)
}
