plugins {
    id("my-java-application")
}

application {
    mainClass.set("org.example.app.App")
}

dependencies {
    implementation(project(":business-logic"))

    runtimeOnly("org.slf4j:slf4j-simple:2.0.7")
}