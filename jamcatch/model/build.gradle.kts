plugins {
    id("my-kotlin-library")
    id("maven-publish")
}

version = "1.0"

publishing {
    repositories { maven("../test-repo") { name = "test"} }
}