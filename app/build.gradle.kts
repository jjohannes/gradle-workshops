plugins {
    id("my-java-application")
}

application {
    mainClass = "org.example.app.Main"
}

dependencies {
    implementation(project(":logic"))
}

