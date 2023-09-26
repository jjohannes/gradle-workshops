plugins {
    id("my-java-library")
}

dependencies {
    api(project(":data-model"))
    implementation("org.apache.commons:commons-text:1.5")
    implementation("org.slf4j:slf4j-api:2.0.7")
}