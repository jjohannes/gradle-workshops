plugins {
    id("my-java-library")
    // id("org.gradlex.jvm-dependency-conflict-resolution") version "2.4"
}

dependencies {
    api(project(":model"))
}
