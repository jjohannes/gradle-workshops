plugins {
    id("my-java-application")
}

application {
    mainClass.set("org.example.app.App")
}

dependencies {
    implementation(project(":business-logic"))
}