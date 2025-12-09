plugins {
    id("my-java-library")
    id("java-test-fixtures")
    // id("org.gradlex.jvm-dependency-conflict-resolution") version "2.4"
}

dependencies {
    api(project(":model"))

    // testFixturesImplementation("com:example")
}
