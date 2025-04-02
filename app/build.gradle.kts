plugins {
    id("com.example.java-application")
}

application {
    mainClass = "com.example.app.App"
}

dependencies {
    implementation(project(":logic"))
    implementation(libs.commons.lang3)

    runtimeOnly(libs.slf4j.simple)
}