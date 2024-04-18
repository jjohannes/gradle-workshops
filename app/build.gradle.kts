plugins {
    id("org.example.java-application")
}

application {
    mainClass = "org.example.app.Main"
}

dependencies {
    implementation(project(":business-logic"))
}
