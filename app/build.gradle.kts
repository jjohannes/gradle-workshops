plugins {
    id("my-java-application")
}

application {
    mainClass.set("org.example.app.App")
}

configurations {
    compileClasspath.get().shouldResolveConsistentlyWith(
        runtimeClasspath.get()
    )
}

dependencies {
    implementation(platform(project(":dependency-versions")))

    implementation(project(":data-model"))
    implementation(project(":business-logic"))
    implementation("org.apache.commons:commons-lang3")

    runtimeOnly("org.slf4j:slf4j-simple")
}