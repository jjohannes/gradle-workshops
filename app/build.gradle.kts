plugins {
    id("com.example.java-application")
}

application {
    mainClass = "com.example.app.App"
}

dependencies {
    implementation(project(":logic"))
}