plugins {
    id("my-java-application")
}

dependencies {
    implementation(project(":model"))
    implementation(project(":engine"))
    implementation("org.apache.commons:commons-csv:1.14.1")
    implementation("org.slf4j:slf4j-api:2.0.17")

    runtimeOnly(project(":renderer"))
    runtimeOnly("org.slf4j:slf4j-simple:2.0.17")
}
