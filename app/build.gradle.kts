plugins {
    id("application")
}

application {
    mainClass = "org.example.app.Main"
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(21)
}
