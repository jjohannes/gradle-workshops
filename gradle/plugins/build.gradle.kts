plugins {
    `kotlin-dsl` // id("kotlin-dsl")
    // `java-gradle-plugin`
    // `groovy-gradle-plugin`
    // `maven-publish`
}

repositories.gradlePluginPortal()

gradlePlugin.plugins.create("my-java-library2") {
    id = "my-java-library2"
    implementationClass = "MyJavaLibrary"
}

dependencies {
    // implementation("")
}
