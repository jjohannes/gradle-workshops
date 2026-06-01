plugins {
    id("my-kotlin-app")
}

dependencies {
    jvmMainApi(project(":model"))
    jvmMainImplementation(project(":engine"))
    jvmMainImplementation("org.apache.commons:commons-csv:1.14.1")
    jvmMainImplementation("commons-io:commons-io:2.20.0")
    jvmMainImplementation("org.slf4j:slf4j-api:2.0.17")

    commonMainRuntimeOnly(project(":renderer"))
    commonMainRuntimeOnly("org.slf4j:slf4j-simple:2.0.17")
}