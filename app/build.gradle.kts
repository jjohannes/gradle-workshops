plugins {
    id("my-java-application")
}

application {
    mainClass = "org.example.app.Main"
}

dependencies {
    implementation(libs.commons.lang)
    implementation(libs.commons.text)

    implementation(project(":logic"))
}
