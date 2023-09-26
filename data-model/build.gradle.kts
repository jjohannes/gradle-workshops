plugins {
    id("my-java-library")
}

dependencies {
    implementation(platform(project(":dependency-versions")))
}
