plugins {
    id("my-java-application")
}

dependencies {
    implementation(project(":model"))
    implementation(project(":engine"))
    implementation("org.apache.commons:commons-csv:1.14.1")
    implementation("commons-io:commons-io:2.20.0")
    implementation("org.slf4j:slf4j-api:2.0.17")

    runtimeOnly(project(":renderer"))
    runtimeOnly("org.slf4j:slf4j-simple:2.0.17")

    testImplementation("org.junit.jupiter:junit-jupiter-api:6.0.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:6.0.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:6.0.2")
}
