plugins {
    id("my-java-library")
}

dependencies {
    implementation(platform(project(":dependency-versions")))

    implementation(project(":data-model"))
    implementation("org.apache.commons:commons-text")
    implementation("org.slf4j:slf4j-api")
}